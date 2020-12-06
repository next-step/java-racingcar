package racing;

public class Car {
    private int moveCount = 0;

    public void move() {
        moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
