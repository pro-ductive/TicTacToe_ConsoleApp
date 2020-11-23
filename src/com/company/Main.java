package com.company;

public class Main {


    public static void main(String[] args) {
        boolean play = true;
        String chance = "x";
        AI_bot ai = new AI_bot();
        Engine e = new Engine();
        String[] chs = {"x", "o"};
        e.showBoard(e.board);

//        while (play) {
//            while (play) {
//                int ch = e.getInput(chance);
//                if (ch>0 && ch<10) {
//                    if (e.avail(ch, e.board)) {
//                        e.updateBoard(ch, chance);
//                        break;
//                    } else {
//
//                    }
//                }
//            }

        while (play) {
            if (chance == "x") {
                while (play) {
                    int ch = e.getInput(chance);
                    if (ch > 0 && ch < 10) {
                        if (e.avail(ch, e.board)) {
                            e.updateBoard(ch, chance);
                            break;
                        } else {

                        }
                    }
                }
            }
            chance = e.swapChance(chance);


            ai.botChance(e.board);
            e.showBoard(e.board);
            if (e.checkWin(e.board, "x")) {
                System.out.println("x won the game");
                play = false;
                break;
            } else if (e.checkWin(e.board, "o")) {
                System.out.println("o won the game");
                play = false;
                break;
            } else if (e.checkBoard(e.board)) {
                System.out.println("Draw");
                play = false;
                break;
            }
            chance = e.swapChance(chance);

        }

    }
}

