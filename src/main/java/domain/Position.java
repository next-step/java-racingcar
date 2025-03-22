package domain;

public class Position {

    private int currentPosition = 0;

    public void move(int diceResult) {
        if (diceResult >= 4) {
            currentPosition++;
        }
    }

    public int currentPosition() {
        return currentPosition;
    }

}
