package com.brownj;

public class Board {

    private char[][] table;

    public Board(){
        table = new char[3][3];

    }

    public void setBoard(){
        for(int i = 0; i < table.length; i++){

            for(int j = 0; j < table.length; j++){
                table[i][j] = ' ';
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i < table.length; i++){
            System.out.println("===============");
            for(int j = 0; j < table.length; j++){

                System.out.print("| ");
                System.out.print(table[i][j]);
                System.out.print(" |");
            }
            System.out.println();


        }
        System.out.println("===============");
    }

    public char getBoardStatus(int x, int y){

        return table[x][y];

    }



    public boolean updateBoard(int x, int y, char playerPiece){

        if(x < table.length && y < table.length) {

            if (String.valueOf(getBoardStatus(x, y)).equals(" ")) {

                table[x][y] = playerPiece;
                return true;
            }
        }

        return false;
    }

    public int getLength(){
        return table.length;
    }
}//End class
