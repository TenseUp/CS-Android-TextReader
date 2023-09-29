package com.example.androidtextreader;
import java.util.*;
import java.io.*;
class TextReader{
    private ArrayList<String> arr = new ArrayList();
    private ArrayList<String> common = new ArrayList();



    public TextReader(InputStream textFile, InputStream commonFile){
        try {
            Scanner textScanner = new Scanner(textFile);
            Scanner commonScanner = new Scanner(commonFile);
            while (commonScanner.hasNext()) {
                common.add(commonScanner.next().toLowerCase());
            }
            while (textScanner.hasNext()) {
                String word = textScanner.next().toLowerCase();
                word = word.replace(".", "");
                word = word.replace("?", "");
                word = word.replace(",", "");
                word = word.replace("!", "");
                if (!common.contains(word.toLowerCase())) if(!Arrays.asList(word.toLowerCase().split("")).contains("’")) arr.add(word);
            }
        }
        catch (Exception e){System.out.println("ERROR");}
    }

    public ArrayList<String> getArr() {
        return arr;
    }




}
