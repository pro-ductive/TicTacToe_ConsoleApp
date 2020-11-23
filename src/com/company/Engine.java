
// importing the stuff
package com.company;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    // Class variables;
    String[][] board;
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();


    Engine(){
        String[] b1 = {".",".","."};
        String[] b2 = {".",".","."};
        String[] b3 = {".",".","."};
        String[][] board ={ b1,b2,b3};
        this.board=board;
    }
    public String[][] createBoard(){
        String[] b1 = {".",".","."};
        String[] b2 = {".",".","."};
        String[] b3 = {".",".","."};
        String[][] board ={ b1,b2,b3};
        this.board=board;
        return board;
    }
    public void showBoard(String[][] board){
        for(String[] b : board){
            for(String u: b){
                System.out.print(" "+u+" ");

            }
            System.out.println();
        }
    }
    public int getInput(String l){
        System.out.print(l+" to go ->");
        String input =sc.next();
        try{
            int intInput=Integer.valueOf(input);
            return intInput;
        }
        catch (Exception e){

        }


        return 0;
    }
    public int[] intToAdd(int i){
        i--;
        int[] vals= new int[2];
        int val1= (i/3)+1;
        int val2= (i%3)+1;
        vals[0]=val1;
        vals[1]=val2;
        return vals;
    }
    public void updateBoard(int input,String l){
        int ad1=intToAdd(input)[0];
        int ad2=intToAdd(input)[1];
        this.board[--ad1][--ad2]=l;

    }
    public boolean checkWin(String[][] board,String l){
        int[] win1={1,2,3};
        int[] win2={4,5,6};
        int[] win3={7,8,9};
        int[] win4={1,4,7};
        int[] win5={2,5,8};
        int[] win6={3,6,9};
        int[] win7={1,5,9};
        int[] win8={3,5,7};
        int[][] wins={win1,win2,win3,win4,win4,win5,win6,win7,win8};
        for(int[] i : wins){
            int[] i1=this.intToAdd(i[0]);
            i1[1]--;
            i1[0]--;
            int[] i2=this.intToAdd(i[1]);
            int[] i3=this.intToAdd(i[2]);

            i2[1]--;
            i2[0]--;i3[1]--;
            i3[0]--;

            if (board[i1[0]][i1[1]]==l && board[i2[0]][i2[1]]==l && board[i3[0]][i3[1]]==l){
                return true;

            }
        }
        return false;
    }

    public String swapChance(String current) {
        if (current == "x") {
            return "o";
        } else {
            return "x";
        }

    }

    public boolean avail(int num, String[][] board) {

        int[] add = this.intToAdd(num);
        int ad1 = --add[0];
        int ad2 = --add[1];
        return board[ad1][ad2] == ".";


    }

    public boolean checkBoard(String[][] board) {
        int[] arr = {0, 1, 2};
        for (int i : arr) {
            for (int j : arr) {
                if (board[i][j] == ".") {
                    return false;
                }
            }
        }
        return true;
    }


}
