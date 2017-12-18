package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] row1 = { "-", "-", "-"};
        String[] row2 = { "-", "-", "-"};
        String[] row3 = { "-", "-", "-"};

        String currentToken = "X";

        System.out.println("You are X's");
        while(true){
            printGrid(row1, row2, row3);
            System.out.println("Its your turn");
            System.out.println("Whats your move? (x,y)");
            int xPos = input.nextInt();
            int yPos = input.nextInt();

            move(row1, row2, row3, currentToken, xPos, yPos);

            if (currentToken == "X")
                currentToken = "O";
            else currentToken = "X";
        }
    }

    public static void printGrid(String[] col1, String[]col2, String[]col3){

        System.out.println(col1[0] + " | " + col1[1] +" | "+ col1[2] + "\n" +
                col2[0] + " | " + col2[1] +" | "+ col2[2] + "\n" +
                col3[0] + " | " + col3[1] +" | "+ col3[2]);
    }

    public static void move(String[] row1, String[] row2, String[] row3, String currToken, int xPos, int yPos){

        if (xPos == 1){

            if (yPos == 1)
                row3[0] = currToken;

            else if (yPos == 2)
                row2[0] = currToken;

            else
                row1[0] = currToken;

        } else if (xPos == 2){

            if (yPos == 1)
                row3[1] = currToken;

            else if (yPos == 2)
                row2[1] = currToken;

            else
                row1[1] = currToken;

        } else if (xPos == 3){

            if (yPos == 1)
                row3[2] = currToken;

            else if (yPos == 2)
                row2[2] = currToken;

            else
                row1[2] = currToken;

        }
    }
}
