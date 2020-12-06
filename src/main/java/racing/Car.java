package racing;

public class Car {
    private int moveCount;

    public void move() {
        moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
