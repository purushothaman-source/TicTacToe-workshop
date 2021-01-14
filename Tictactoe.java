package com.workshop;

import java.util.Scanner;

public class Tictactoe {

    public static void main(String[] args) {
        char[] board=createBoard();
        Scanner userInput=new Scanner(System.in);
        char userLetter =chooseUserLetter(userInput);
        char computeLetter =(userLetter == 'X')?'0':'x';
        showBoard(board);
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
    public static void showBoard(char[] Board)
    {
        System.out.println("");
        for(int i =1 ; i<Board.length ;i++)
        {
            System.out.print("|_"+Board[i] + "_|");
            if(i%3==0)
            {
                System.out.print(System.lineSeparator());
                System.out.println("---------------");
            }
        }
    }
}