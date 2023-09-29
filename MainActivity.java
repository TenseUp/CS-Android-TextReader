package com.example.androidtextreader;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity{
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                String[] tops = go(input);
                TextView top5Text = findViewById(R.id.top5Text);
                top5Text.setText(tops[0]);
                TextView topWordText = findViewById(R.id.topWordText);
                topWordText.setText(tops[1]);
            }
        });
    }

    public String[] go(String input){
        String fileName = input + ".txt";
        String commonName = "commonWords.txt";
        InputStream textFile = null,commonFile = null;
        try {
            textFile = getAssets().open(fileName);
            commonFile = getAssets().open(commonName);
        } catch(Exception e){System.out.println(e);}
        Count count = new Count(textFile, commonFile);
        String[] arr1 = count.getRankString();
        int[] arr2 = count.getRankInt();
        String top5 = "";
        for(int i = 0; i < arr1.length; i++){

            top5 += i+1 + ". " + arr1[i] + ": " + arr2[i] + "\n";
        }
        String top = arr1[0] + ": " + arr2[0];
        String[] tops = new String[2];
        tops[0] = top5;
        tops[1] = top;
        return tops;
    }
}