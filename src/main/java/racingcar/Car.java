package racingcar;

public class Car {

    private static final int THRESHOLD = 4;
    private int moveCount = 0;

    public int getMoveCount() {
        return moveCount;
    }

    public void move(int givenNumber) {
        if (givenNumber >= THRESHOLD) {
            moveCount++;
        }
    }
}