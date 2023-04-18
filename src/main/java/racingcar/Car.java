package racingcar;

public class Car {

    private int moveCount;

    private Car() {
    }

    private Car(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        this.moveCount++;
    }

    public static Car create() {
        return new Car(0);
    }

    public static Car of(int moveCount) {
        return new Car(moveCount);
    }
}
