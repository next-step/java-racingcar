package step3.common.vo;

public class Car {

    private final int number;

    private int moveCount = 0;

    public Car(int number) {
        this.number = number;
    }

    public void move() {
        moveCount++;
    }

    public int getNumber() {
        return number;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
