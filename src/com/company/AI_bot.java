
package com.company;

class initialMethods{




}


public class AI_bot {
    Engine e = new Engine();

    public void botChance(String[][] board) {
        String[][] board2 = board;

        int bestScore = -9;
        int bestMove1 = -1;
        int bestMove2 = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board2[i][j] == ".") {

                    board2[i][j] = "o";
                    int score = minimax(false, board2);
                    board2[i][j] = ".";
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove1 = i;
                        bestMove2 = j;
                    }


                }


            }
        }

        if (!e.checkBoard(board)) {
            board[bestMove1][bestMove2] = "o";
        }


    }

    public int minimax(boolean maximizing, String[][] board) {
        String[][] board2 = board;

        if (e.checkWin(board, "o")) {
            return 1;
        } else if (e.checkWin(board, "x")) {
            return -1;
        } else if (e.checkBoard(board)) {
            return 0;
        }
        if (maximizing) {
            int bestScore = -9;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board2[i][j] == ".") {

                        board2[i][j] = "o";
                        int score = minimax(false, board2);
                        board2[i][j] = ".";
                        if (score > bestScore) {
                            bestScore = score;
                        }


                    }


                }
            }
            return bestScore;


        } else {
            int bestScore = 9;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board2[i][j] == ".") {

                        board2[i][j] = "x";
                        int score = minimax(true, board2);
                        board2[i][j] = ".";
                        if (score < bestScore) {
                            bestScore = score;
                        }


                    }


                }
            }
            return bestScore;

        }


    }
}
