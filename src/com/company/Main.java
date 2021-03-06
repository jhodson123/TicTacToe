package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static Random rand = new Random();

    private static String currentToken = "X";
    private static int row;
    private static int col;

    private static String[][] board = new String[][]{{"-","-","-"},
            {"-","-","-"},
            {"-","-","-"}};

    public static void main(String[] args) {

        int loopCount = 0;

        System.out.println("You are X's");
        while(loopCount < 9){
            printGrid();

            if (currentToken.equals("X")){

                System.out.println("Its your turn");
                getInput();
                if (row == 4){
                    break;
                }
            }else{

                System.out.println("Computer's Turn");
                findAiMove();
                System.out.println("Computer's move: " + row + ", " + col);
            }

            if (currentToken.equals("X"))
                currentToken = "O";
            else currentToken = "X";

            loopCount++;
        }
        printGrid();
        System.out.println("Stalemate");
        System.exit(3024);
    }

    private static void printGrid(){

        for (int i=0; i<board.length; i++){
            for (int j=0; j<board.length; j++){

                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }

    private static void getInput(){

        System.out.println("Whats your move? (x,y)");
        row = input.nextInt();
        col = input.nextInt();

        findMove();
    }

    private static void findMove(){

        if (board[row - 1][col - 1].equalsIgnoreCase("-")) {
            board[row - 1][col - 1] = currentToken;
        }else {
            System.out.println("Invalid Move");
            getInput();
        }

        check();
    }

    private static void findAiMove(){
        String temp = null;
        boolean foundMove = false;
        for(int i=0; i<board.length;i++){

            temp = board[i][0]+board[i][1]+board[i][2];

            //check if winning row
            if(temp.indexOf("OO") == 0 && !foundMove){
                row = i;
                col = 2;
                foundMove = true;
                break;
            }else if (temp.indexOf("OO") == 1 && !foundMove){
                row = i;
                col = 0;
                foundMove = true;
                break;
            }else if (temp.indexOf("O-O") == 0 && !foundMove){
                row = i;
                col = 1;
                foundMove = true;
                break;
            }
            System.out.println(foundMove);
            //check for winning col
            temp = board[0][i]+board[1][i]+board[2][i];
            System.out.println(temp);
            if(temp.indexOf("OO") == 0 && !foundMove){
                row = 2;
                col = i;
                foundMove = true;
                break;
            }else if (temp.indexOf("OO") == 1 && !foundMove){
                row = 0;
                col = i;
                foundMove = true;
                break;
            }else if (temp.indexOf("O-O") == 0 && !foundMove){
                row = 1;
                col = i;
                foundMove = true;
                break;
            }

            temp = board[i][0]+board[i][1]+board[i][2];
            //row
            if (temp.indexOf("XX") == 0 && temp.indexOf("O") != 2 && !foundMove){
                row = i;
                col = 2;
                foundMove = true;
                break;
            }else if (temp.indexOf("XX") == 1 && temp.indexOf("O") != 0 && !foundMove){
                row = i;
                col = 0;
                foundMove = true;
                break;
            }else if (temp.indexOf("X-X") == 0 && temp.indexOf("O") != 1 && !foundMove){
                row = i;
                col = 1;
                foundMove = true;
                break;
            }


            temp = board[0][i]+board[1][i]+board[2][i];
            //col
            if (temp.indexOf("XX") == 0 && temp.indexOf("O") != 2 && !foundMove){
                row = 2;
                col = i;
                foundMove = true;
                break;
            }else if (temp.indexOf("XX") == 1 && temp.indexOf("O") != 0 && !foundMove){
                row = 0;
                col = i;
                foundMove = true;
                break;
            }else if (temp.indexOf("X-X") == 0 && temp.indexOf("O") != 1 && !foundMove){
                row = 1;
                col = i;
                foundMove = true;
                break;
            }
        }

        if (!temp.contains("XX") && !temp.contains("X-X") && !foundMove){
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        }

        if (board[row][col].equalsIgnoreCase("-")) {
            board[row][col] = currentToken;
        }else
            findAiMove();

        check();
    }

    private static void winMove(){

        //check if winning row
        /*if(){
            row = ;
            col = 2;
            break;
        }else if (){
            row = i
            col = 0;
            break;
        }else if (){
            row = i;
            col = 1;
            break;
        }
        //check for winning col
        if(){
            row = 2;
            col = i;
            break;
        }else if (){
            row = 0;
            col = i;
            break;
        }else if (){
            row = 1;
            col = i;
            break;
        }

        //row
        if (){
            row = ;
            col = 2;
            break;
        }else if (){
            row = ;
            col = 0;
            break;
        }else if (){
            row = ;
            col = 1;
            break;
        }

        //col
        if (){
            row = 2;
            col = ;
            break;
        }else if (){
            row = 0;
            col = ;
            break;
        }else if (){
            row = 1;
            col = ;
            break;
        }
    }*/
    }

    private static void check(){

        for (int i=0; i<board.length; i++) {
            if (board[i][0].equals(currentToken) && board[i][1].equals(currentToken) && board[i][2].equals(currentToken)) {

                if (currentToken.equals("X"))
                    System.out.println("You Win");
                else
                    System.out.println("Computer Wins");
                printGrid();
                System.exit(0);
            }
            if (board[0][i].equals(currentToken) && board[1][i].equals(currentToken) && board[2][i].equals(currentToken)) {

                if (currentToken.equals("X"))
                    System.out.println("You Win");
                else
                    System.out.println("Computer Wins");
                printGrid();
                System.exit(0);
            }
        }

        if (board[0][0].equals(currentToken) && board[1][1].equals(currentToken) && board[2][2].equals(currentToken)){

            if (currentToken.equals("X"))
                System.out.println("You Win");
            else
                System.out.println("Computer Wins");
            printGrid();
            System.exit(0);
        }
        if (board[0][2].equals(currentToken) && board[1][1].equals(currentToken) && board[2][0].equals(currentToken)){

            if (currentToken.equals("X"))
                System.out.println("You Win");
            else
                System.out.println("Computer Wins");
            printGrid();
            System.exit(0);
        }
    }
}
