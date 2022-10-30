package racing.domain;

public class Car {
    private int moveCount;
    private static final int MAKE_RANDOM_NUMBER = 10;
    private static final int MOVEABLE_NUMBER = 4;

    public void move() {
        int randomNumber = (int)(Math.random() * MAKE_RANDOM_NUMBER);
        if (randomNumber >= MOVEABLE_NUMBER) {
            this.moveCount++;
        }
    }

    public int getMoveCount() {
        return this.moveCount;
    }
}
