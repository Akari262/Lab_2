package com.laboratorna;

import java.io.*;

public class Main {
    public static int[][] dataArray = new int[3][3];
    public static String[][] resultArray = new String[3][6];
    public static double[][] sevidghArray = new double[3][3];
    public static double coef = 0;

    //функція, яка отримує дані з файлу і виводить їх на екран
    public static void arrData() throws IOException {
        String file = "data.csv";
        BufferedReader reader = null;
        String line = "";
        reader = new BufferedReader(new FileReader(file));
        int x = 0;
        while((line = reader.readLine()) != null && x < 5){
            String [] row = line.split(";");
            for(int i = 0; i < 3; i++){
                dataArray[x][i] = Integer.parseInt(row[i]);
            }
            x++;
        }

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i][0] = "K"+ (i+1);
        }

        //Вивід матриці
        System.out.println("Matrix:");
        for (int i = 0; i < dataArray.length; i++) {
            for (int j = 0; j < dataArray[i].length; j++) {
                System.out.print(dataArray[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void printData(){
        //Вивід матриці
        System.out.println("Results");
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                System.out.print(resultArray[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void vald(){
        var nums = new double[3];
        for (int i = 0; i < dataArray.length; i++) {
            nums[i] = Math.min(Math.min(dataArray[i][0], dataArray[i][1]),dataArray[i][2]);
        }
        max(nums, 1);
    }

    public static void sevidg(){
        var nums = new double[3];
        for (int i = 0; i < dataArray.length; i++) {
            nums[i] = Math.max(Math.max(dataArray[i][0], dataArray[i][1]),dataArray[i][2]);
        }
        min(nums, 2);
    }

    public static void laplas(){
        var nums = new double[3];
        double x = 1.0 / dataArray.length;
        for (int i = 0; i < dataArray.length; i++) {
            nums[i] = x * (dataArray[i][0] + dataArray[i][1] + dataArray[i][2]);
        }
        max(nums, 4);
    }

    public static void gurvits(){
        var num = new double[3];
        for (int i = 0; i < dataArray.length; i++) {
            num[i] = coef * Math.max(Math.max(dataArray[i][0], dataArray[i][1]),dataArray[i][2]) + (1 - coef) * Math.min(Math.min(dataArray[i][0], dataArray[i][1]),dataArray[i][2]);
        }
        max(num, 3);
    }

    public static void sevidgh2(){
        var nums = new double[3];
        var max = new double[3];
        for (int i = 0; i < dataArray.length; i++) {
            max[i] = Math.max(Math.max(dataArray[0][i], dataArray[1][i]),dataArray[2][i]);
        }
        System.out.println("Matrix of regret");
        for (int i = 0; i < dataArray.length; i++) {
            for (int j = 0; j < dataArray[i].length; j++) {
                sevidghArray[i][j] =  max[j] - dataArray[i][j];
                System.out.print(sevidghArray[i][j] + "\t");
            }
            System.out.println();
        }
        for (int i = 0; i < sevidghArray.length; i++) {
            nums[i] = Math.max(Math.max(sevidghArray[i][0], sevidghArray[i][1]),sevidghArray[i][2]);
        }
        min(nums, 5);
        System.out.println();
    }

    public static void min(double nums[], int x){
        var min = Math.min(Math.min(nums[0], nums[1]),nums[2]);

        for(int i = 0;i < nums.length; i++) {
            if(min == nums[i])
                resultArray[i][x] = nums[i] + "!";
            else
                resultArray[i][x] = Double.toString(nums[i]);
        }
    }

    public static void max(double nums[], int x){
        var max = Math.max(Math.max(nums[0], nums[1]),nums[2]);;
        for(int i = 0;i < nums.length; i++) {
            if(max == nums[i])
                resultArray[i][x] = nums[i] + "!";
            else
                resultArray[i][x] = Double.toString(nums[i]);
        }
    }


    public static void main(String[] args) throws IOException {
        arrData();
        vald();
        sevidg();
        coef = 0.3;
        gurvits();
        laplas();
        sevidgh2();
        printData();
    }
}