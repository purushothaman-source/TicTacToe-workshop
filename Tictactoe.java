package com.workshop;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tictactoe {

    public static final int Head = 0;
    public static final int Tail = 1;
    public static char won;
    public static char draw = 'd';
    static char userLetter;
    static char computerLetter;

    public enum Player {USER, COMPUTER}

    public static void main(String[] args) {

        char[] board = createBoard();
        Scanner userInput = new Scanner(System.in);
        userLetter = chooseUserLetter(userInput);
        computerLetter = (userLetter == 'X') ? '0' : 'x';
        Player player = getWhoStartsFirst();
        if (player.equals(Player.USER)) {
            do {
                showBoard(board);
                int userMove = getUserMove(board, userInput);
                makeMove(board, userMove, userLetter);
                won = gameStatus(userLetter, board);
                if (won == userLetter || won == draw) {
                    break;
                }
                int computermove = getComputerMove(board);
                makeMove(board, computermove, computerLetter);
                won = gameStatus(computerLetter, board);
            } while ((won != userLetter) && (won != computerLetter) && (won != 'd'));
        } else {
            do {
                int computermove = getComputerMove(board);
                makeMove(board, computermove, computerLetter);
                won = gameStatus(computerLetter, board);
                if (won == computerLetter || won == draw) {
                    break;
                }
                showBoard(board);
                int userMove = getUserMove(board, userInput);
                makeMove(board, userMove, userLetter);
                won = gameStatus(userLetter, board);

            } while ((won != userLetter) && (won != computerLetter) && (won != 'd'));
        }
        System.out.println("");
        if (won == userLetter)
            System.out.println("Playerwon");
        else if (won == computerLetter)
            System.out.println("Computerwon");
        else if (won == draw)
            System.out.println("Match drawn");

    }

    private static char[] createBoard() {
        char[] board = new char[10];
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }

    private static char chooseUserLetter(Scanner userInput) {
        System.out.println("choose your letter: ");
        return userInput.next().toUpperCase().charAt(0);
    }

    public static void showBoard(char[] Board) {
        System.out.println("");
        for (int i = 1; i < Board.length; i++) {
            System.out.print("|_" + Board[i] + "_|");
            if (i % 3 == 0) {
                System.out.print(System.lineSeparator());
                System.out.println("---------------");
            }
        }
    }

    private static int getUserMove(char[] board, Scanner userInput) {
        Integer[] validCells = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        while (true) {
            System.out.println("what is your next move?(1-9): ");
            int index = userInput.nextInt();
            if (Arrays.asList(validCells).contains(index) && isSpaceFree(board, index))
                return index;
            System.out.println("Invalid cell ,Try again");

        }
    }

    private static int getComputerMove(char[] board) {
        Integer[] validCells = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String checkWinningMove = "" + computerLetter + computerLetter;
        String blockOpponentWinningMove=""+userLetter+userLetter;
        int index;
        while (true) {
            if ((checkWinningMove.equals("" + board[2] + board[3])
                    || checkWinningMove.equals("" + board[4] + board[7])
                    || checkWinningMove.equals("" + board[5] + board[9]))
                    && board[1] == ' ')
                index = 1;
            else if ((checkWinningMove.equals("" + board[1] + board[3])
                    || checkWinningMove.equals("" + board[5] + board[8]))
                    && board[2] == ' ')
                index = 2;
            else if ((checkWinningMove.equals("" + board[1] + board[2])
                    || checkWinningMove.equals("" + board[6] + board[9])
                    || checkWinningMove.equals("" + board[5] + board[7]))
                    && board[3] == ' ')
                index = 3;
            else if ((checkWinningMove.equals("" + board[5] + board[6])
                    || checkWinningMove.equals("" + board[1] + board[7]))
                    && board[4] == ' ')
                index = 4;
            else if ((checkWinningMove.equals("" + board[4] + board[6])
                    || checkWinningMove.equals("" + board[2] + board[8])
                    || checkWinningMove.equals("" + board[1] + board[9])
                    || checkWinningMove.equals("" + board[3] + board[7]))
                    && board[5] == ' ')
                index = 5;
            else if ((checkWinningMove.equals("" + board[4] + board[5])
                    || checkWinningMove.equals("" + board[3] + board[9]))
                    && board[6] == ' ')
                index = 6;
            else if ((checkWinningMove.equals("" + board[8] + board[9])
                    || checkWinningMove.equals("" + board[1] + board[4])
                    || checkWinningMove.equals("" + board[3] + board[5]))
                    && board[7] == ' ')
                index = 7;
            else if ((checkWinningMove.equals("" + board[7] + board[9])
                    || checkWinningMove.equals("" + board[2] + board[5]))
                    && board[8] == ' ')
                index = 8;
            else if ((checkWinningMove.equals("" + board[7] + board[8])
                    || checkWinningMove.equals("" + board[3] + board[6])
                    || checkWinningMove.equals("" + board[1] + board[5]))
                    && board[9] == ' ')
                index = 9;
            else if ((blockOpponentWinningMove.equals("" + board[2] + board[3])
                    || blockOpponentWinningMove.equals("" + board[4] + board[7])
                    || blockOpponentWinningMove.equals("" + board[5] + board[9]))
                    && board[1] == ' ')
                index = 1;
            else if ((blockOpponentWinningMove.equals("" + board[1] + board[3])
                    || blockOpponentWinningMove.equals("" + board[5] + board[8]))
                    && board[2] == ' ')
                index = 2;
            else if ((blockOpponentWinningMove.equals("" + board[1] + board[2])
                    || blockOpponentWinningMove.equals("" + board[6] + board[9])
                    || blockOpponentWinningMove.equals("" + board[5] + board[7]))
                    && board[3] == ' ')
                index = 3;
            else if ((blockOpponentWinningMove.equals("" + board[5] + board[6])
                    || blockOpponentWinningMove.equals("" + board[1] + board[7]))
                    && board[4] == ' ')
                index = 4;
            else if ((blockOpponentWinningMove.equals("" + board[4] + board[6])
                    || blockOpponentWinningMove.equals("" + board[2] + board[8])
                    || blockOpponentWinningMove.equals("" + board[1] + board[9])
                    || blockOpponentWinningMove.equals("" + board[3] + board[7]))
                    && board[5] == ' ')
                index = 5;
            else if ((blockOpponentWinningMove.equals("" + board[4] + board[5])
                    || blockOpponentWinningMove.equals("" + board[3] + board[9]))
                    && board[6] == ' ')
                index = 6;
            else if ((blockOpponentWinningMove.equals("" + board[8] + board[9])
                    || blockOpponentWinningMove.equals("" + board[1] + board[4])
                    || blockOpponentWinningMove.equals("" + board[3] + board[5]))
                    && board[7] == ' ')
                index = 7;
            else if ((blockOpponentWinningMove.equals("" + board[7] + board[9])
                    || blockOpponentWinningMove.equals("" + board[2] + board[5]))
                    && board[8] == ' ')
                index = 8;
            else if ((blockOpponentWinningMove.equals("" + board[7] + board[8])
                    || blockOpponentWinningMove.equals("" + board[3] + board[6])
                    || blockOpponentWinningMove.equals("" + board[1] + board[5]))
                    && board[9] == ' ')
                index = 9;
            else {
                Random random = new Random();
                index = random.nextInt(9) + 1;
            }
            if (Arrays.asList(validCells).contains(index) && isSpaceFree(board, index)) {
                System.out.println("computer index : " + index);
                return index;
            }
        }
    }

    private static boolean isSpaceFree(char[] board, int index) {
        return board[index] == ' ';
    }

    private static void makeMove(char[] board, int index, char letter) {
        boolean spaceFree = isSpaceFree(board, index);
        if (spaceFree)
            board[index] = letter;
    }

    private static Player getWhoStartsFirst() {
        Random random = new Random();
        int toss = random.nextInt(2);
        return (toss == Head) ? Player.USER : Player.COMPUTER;
    }

    private static char gameStatus(char letter, char[] board) {
        String win = "" + letter + letter + letter;
        if (win.equals("" + board[1] + board[2] + board[3])
                || win.equals("" + board[4] + board[5] + board[6])
                || win.equals("" + board[7] + board[8] + board[9]))
            return letter;
        else if (win.equals("" + board[1] + board[4] + board[7])
                || win.equals("" + board[2] + board[5] + board[8])
                || win.equals("" + board[3] + board[6] + board[9]))
            return letter;
        else if (win.equals("" + board[1] + board[5] + board[9])
                || win.equals("" + board[3] + board[5] + board[7]))
            return letter;
        else if (true) {
            boolean draw = isDraw(board);
            if (draw == true)
                return 'd';
        } else {
            return 'c';
        }
        return 'q';
    }

    private static boolean isDraw(char[] board) {
        return (board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' ' && board[5] != ' ' &&
                board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ');
    }
}