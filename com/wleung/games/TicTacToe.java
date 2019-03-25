package com.wleung.games;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    static Scanner gameScan;
    static String[] game;
    static String turn;

    public static void main(String[] args) {

        Scanner gameScan = new Scanner(System.in);
        game = new String[9];
        turn = "X";
        String textwinner = null;
        String winner = null;
        resetgame();

        System.out.println("2 Player Tic Tac Toe");
        drawBoard();
        System.out.println("X's will start, please type in a number to put the X.");


        while(winner == null) {
            int numIn = gameScan.nextInt();
            if(!(numIn >= 1 && numIn <= 9)) {
                System.out.println("Not applicable, please re-enter a number");
                continue;
            }
            if(game[numIn-1].equals(String.valueOf(numIn))) {
                game[numIn-1] = turn;
                if(turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                drawBoard();
                winner = winnercheck();
            } else {
                System.out.println("The number you have entered is not valid, please enter a new number.");
            }

        }

        if(winner.equals("draw")) {
            System.out.println("It's a draw.");
        } else {
            if (winner == "X") {
                textwinner = "Player 1";
            } else if (winner == "O") {
                textwinner = "Player 2 ";
            }
            System.out.println("The winner is " + textwinner + "(" + winner + "'s).");
        }
    }

    static String winnercheck() {
        String finwinner = null;

        for (int a = 0; a < 8; a++) {
            String linewin = null;

            //Horizontals
            if(a == 0) {
                linewin = game[0] + game[1] + game[2];
            } else if(a == 1) {
                linewin = game[3] + game[4] + game[5];
            } else if(a == 2) {
                linewin = game[6] + game[7] + game[8];
            } else if(a == 3) { //Verticals
                linewin = game[0] + game[3] + game[6];
            } else if(a == 4) {
                linewin = game[1] + game[4] + game[7];
            } else if(a == 5) {
                linewin = game[2] + game[5] + game[8];
            } else if(a == 6) { //Diagonals
                linewin = game[0] + game[4] + game[8];
            } else if(a == 7) {
                linewin = game[2] + game[4] + game[6];
            }

            if (linewin.equals("XXX")) {
                return "X";
            } else if (linewin.equals("OOO")) {
                return "O";
            }
        }


        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(game).contains(String.valueOf(a+1))) {

            }
            else if (a == 8) {
                return "draw";
            }
        }



        System.out.println("It's " + turn + "'s turn, please type in a number to put the " + turn);
        return null;
    }

//    if( winner == "X"||  winner == "O") {
//
//    }


    static void drawBoard() {
        System.out.println("|---|---|---|" );
        System.out.println("| " + game[0] + " | " + game[1] + " | " + game[2] + " |");
        System.out.println("|---|---|---|" );
        System.out.println("| " + game[3] + " | " + game[4] + " | " + game[5] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + game[6] + " | " + game[7] + " | " + game[8] + " |");
        System.out.println("|---|---|---|");
    }


    static void resetgame() {
        int gamecounter = 0;
        while(gamecounter < 9) {
            game[gamecounter] = String.valueOf(gamecounter + 1);
            gamecounter++;
        }
    }

}
