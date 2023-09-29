package com.example.androidtextreader;
import java.util.*;
import java.io.*;
class Count {
    static String[] rankString = new String[5];
    static int[] rankInt = new int[5];

    ArrayList<String> temp = new ArrayList<>();
    ArrayList<Integer> tempInt = new ArrayList<>();


    Count(InputStream f, InputStream c){
        TextReader textReader = new TextReader(f,c);
        ArrayList<String> arr = textReader.getArr();
        for(String i : arr) {
//            System.out.println(i);
            boolean found = false;
            for(String x : temp) {
                if(i.equals(x)) {
                    tempInt.set(temp.indexOf(x), tempInt.get(temp.indexOf(x))+1);
                    found = true;
                    break;
                }
            }

            if(!found) {
                temp.add(i);
                tempInt.add(1);
            }
        }
        sort();

    }

    public void sort(){
        int max;
        for(int x = 0; x < 5; x ++){
            max = 0;
            for (int i : tempInt){
                if (i>max){
                    max = i;
                }
            }
            rankString[x] = temp.get(tempInt.indexOf(max));
            rankInt[x] = max;
            temp.remove(tempInt.indexOf(max));
            tempInt.remove(tempInt.indexOf(max));
        }


    }



    public String[] getRankString() {
        return rankString;
    }

    public int[] getRankInt() {
        return rankInt;
    }
}