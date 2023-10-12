public class Player {

private String name;
private String marker;
private int wins = 0;
private boolean myTurn;




    public Player(String name, String marker, boolean myTurn) {
        this.name = name;
        this.marker = marker;
        this.myTurn = myTurn;
    }

    // checks if it´s the player turn
    public boolean isMyTurn() {
        return myTurn;
    }


    // change which player turn it is
    public void changeMyTurn() {
        if(this.myTurn) {
            this.myTurn = false;
        } else{
            this.myTurn = true;
        }

    }

    public String getName() {
        return name;
    }

    public String getMarker() {
        return marker;
    }


    public void addWin(){
        wins += 1;
    }

    public int getWins() {
        return wins;
    }

}

