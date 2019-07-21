package com.brownj;

import java.util.Random;

public class Controller {
    private boolean win;
    private boolean draw;
    private int counter;
    private int maxCount;
    private Player player1;
    private Player player2;
    private Board myBoard;
    private Random myRand;
    private String winner;

    public Controller(){
        player1 = new Player(1, 'X');
        player2 = new Player(2, 'O');
        myBoard = new Board();
        win = false;
        draw = false;
        counter = 0;
        maxCount = 9;
        winner = " ";

    }

    public void newGame(){
        myBoard.setBoard();
        runGame();

    }

    private boolean checkIfWin() {


            if(checkHorizontal() || checkVertical() || checkDiagonal()){
                return true;
            }
            else {
                return false;
            }


    }

    public void runGame(){
        int row = 0;
        int column = 0;
        myRand = new Random();

        while(!win && !draw) {


            for(int i = 0; i <= maxCount; i++){
                row = myRand.nextInt(3);
                column = myRand.nextInt(3);

                    if(i%2 == 0) {

                       if(myBoard.updateBoard(row, column, player1.getPlayerPiece())) {
                           counter++;
                       }
                       else{
                           i--;
                       }

                    }
                    else{
                        if(myBoard.updateBoard(row, column, player2.getPlayerPiece())){
                            counter++;
                        }
                        else{
                            i--;
                        }

                    }

                    if(counter >= 4){
                       if(checkIfWin()){
                           win = true;
                           break;
                       }
                    }

                    if(counter == 9){
                        draw = true;
                        break;
                    }
            }
        }
        checkWinOrDraw();

    }//End runGame

    private boolean checkHorizontal(){
        int index = myBoard.getLength();
        int count = 0;
        int count2 = 0;

        //checks Horizontal---------------------------
        for (int row = 0; row < index; row++) {

            for (int column = 0; column < index; column++) {

                if (myBoard.getBoardStatus(row, column) == 'X') {
                    count++;

                    if (count == 3) {
                        winner = "Player " + player1.getPlayer() + " Wins";
                        return true;
                    }

                } else if (myBoard.getBoardStatus(row, column) == 'O' ) {
                    count2++;

                    if (count2 == 3) {
                        winner = "Player " + player2.getPlayer() + " Wins";
                        return true;
                    }

                }

            }
            count = 0;
            count2 = 0;

            }
        return false;
    }

    private boolean checkVertical() {
        int index = myBoard.getLength();
        int count = 0;
        int count2 = 0;

        //checks horizontal---------------------------------------

        for (int row = 0; row < index; row++) {

            for (int column = 0; column < index; column++) {

                if (myBoard.getBoardStatus(column, row) == 'X') {
                    count++;
                    if (count == 3) {
                        winner = "Player " + player1.getPlayer() + " Wins";
                        return true;
                    }

                } else if (myBoard.getBoardStatus(column, row) == 'O') {
                    count2++;

                    if (count2 == 3) {
                        winner = "Player " + player2.getPlayer() + " Wins";
                        return true;
                    }

                }

            }

            count = 0;
            count2 = 0;
        }
        return false;
    }

    private boolean checkDiagonal(){

        if((myBoard.getBoardStatus(0,0) == 'X' && myBoard.getBoardStatus(1,1) == 'X') &&
                (myBoard.getBoardStatus(0,0) == 'X' && myBoard.getBoardStatus(2,2) == 'X') ||
                (myBoard.getBoardStatus(2,0) == 'X' && myBoard.getBoardStatus(1,1) == 'X') &&
                        (myBoard.getBoardStatus(2,0) == 'X' && myBoard.getBoardStatus(0,2) == 'X') ){
            winner = "Player " + player1.getPlayer() + " Wins";
            return true;
        }

        if((myBoard.getBoardStatus(0,0) == 'O' && myBoard.getBoardStatus(1,1) == 'O') &&
                (myBoard.getBoardStatus(0,0) == 'O' && myBoard.getBoardStatus(2,2) == 'O') ||
                (myBoard.getBoardStatus(2,0) == 'O' && myBoard.getBoardStatus(1,1) == 'O') &&
                        (myBoard.getBoardStatus(2,0) == 'O' && myBoard.getBoardStatus(0,2) == 'O') ){
            winner = "Player " + player2.getPlayer() + " Wins";
            return true;
        }
        return false;
    }

    private String getWinner() {
        return winner;
    }

    private void checkWinOrDraw(){
        if(win){
            myBoard.printBoard();
            System.out.println(getWinner());
        }

        if(draw){
            myBoard.printBoard();
            System.out.println("The game is a Draw");
        }
    }
}//End Class
