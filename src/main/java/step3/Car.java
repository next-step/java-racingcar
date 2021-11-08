package step3;

public class Car {

    private final int zero = 0;
    private Count moveCount;

    public Car() {
        moveCount = new Count(zero);
    }

    public void move() {
        moveCount.plusCount();
    }

    public Count currentPos() {
        return moveCount;
    }
}
