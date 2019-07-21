package com.brownj;

public class Player {
    private int player;
    private char playerPiece;

    public Player(int player, char playerPiece){
        this.player = player;
        this.playerPiece = playerPiece;
    }

    public int getPlayer() {
        return player;
    }

    public char getPlayerPiece() {
        return playerPiece;
    }
//probably will delete this function
    @Override
    public String toString() {
        return String.valueOf(playerPiece);
    }
}//End Class
