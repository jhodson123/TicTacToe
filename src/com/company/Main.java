package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static Random rand = new Random();

    public static String currentToken = "X";
    public static int xPos;
    public static int yPos;

    public static String[][] rows = new String[][]{{"-","-","-"},
            {"-","-","-"},
            {"-","-","-"}};

    public static void main(String[] args) {

        System.out.println("You are X's");
        while(true){
            printGrid();

            if (currentToken == "X"){

                System.out.println("Its your turn");
                getInput();
                if (xPos == 4){
                    break;
                }
            }else{

                System.out.println("Computer's Turn");
                findAiMove();
                System.out.println("Computer's move: " + xPos + ", " + yPos);
            }

            if (currentToken == "X")
                currentToken = "O";
            else currentToken = "X";
        }
    }

    public static void printGrid(){

        for (int i=0; i<rows.length; i++){
            for (int j=0; j<rows.length; j++){

                System.out.print("|" + rows[i][j]);
            }
            System.out.println("|");
        }
    }

    public static void getInput(){

        System.out.println("Whats your move? (x,y)");
        xPos = input.nextInt();
        yPos = input.nextInt();

        findMove();
    }

    public static void findMove(){

        if (rows[xPos - 1][yPos - 1].equalsIgnoreCase("-")) {
            rows[xPos - 1][yPos - 1] = currentToken;
        }else {
            System.out.println("Invalid Move");
            getInput();
        }

        check();
    }

    public static void findAiMove(){

        xPos = rand.nextInt(3)+1;
        yPos = rand.nextInt(3)+1;

        if (rows[xPos - 1][yPos - 1].equalsIgnoreCase("-")) {
            rows[xPos - 1][yPos - 1] = currentToken;
        }else
            findAiMove();

        check();
    }

    public static void check(){

        for (int i=0; i<rows.length; i++) {
            if (rows[i][0] == currentToken && rows[i][1] == currentToken && rows[i][2] == currentToken) {

                if (currentToken == "X")
                    System.out.println("You Win");
                else
                    System.out.println("Computer Wins");
                printGrid();
                System.exit(1);
            }
            if (rows[0][i] == currentToken && rows[1][i] == currentToken && rows[2][i] == currentToken) {

                if (currentToken == "X")
                    System.out.println("You Win");
                else
                    System.out.println("Computer Wins");
                printGrid();
                System.exit(1);
            }
        }

        if (rows[0][0] == currentToken && rows[1][1] == currentToken && rows[2][2] == currentToken){

            if (currentToken == "X")
                System.out.println("You Win");
            else
                System.out.println("Computer Wins");
            printGrid();
            System.exit(1);
        }
        if (rows[0][2] == currentToken && rows[1][1] == currentToken && rows[2][0] == currentToken){

            if (currentToken == "X")
                System.out.println("You Win");
            else
                System.out.println("Computer Wins");
            printGrid();
            System.exit(1);
        }
    }
}
