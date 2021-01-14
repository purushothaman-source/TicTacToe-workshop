package com.workshop;

import java.util.Scanner;

public class Tictactoe {

    public static void main(String[] args) {
        char[] board=createBoard();
        Scanner userInput=new Scanner(System.in);
        char userLetter =chooseUserLetter(userInput);
        char computeLetter =(userLetter == 'X')?'0':'x';
    }
    private static char[] createBoard(){
        char[] board=new char[10];
        for (int i=0;i< board.length;i++){
            board[i]=' ';
        }
        return board;
    }
    private static char chooseUserLetter(Scanner userInput) {
        System.out.println("choose your letter: ");
        return userInput.next().toUpperCase().charAt(0);
    }
}