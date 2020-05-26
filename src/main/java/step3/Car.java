package step3;

public class Car {
    private int currentPosition = 0;

    public void move() {
        currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
