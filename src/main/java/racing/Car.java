package racing;

public class Car {

    private int currentPosition = 0;

    public void move() {
        currentPosition++;
    }

    public int currentPosition() {
        return currentPosition;
    }
}
