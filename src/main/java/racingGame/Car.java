package racingGame;

public class Car {

    private int position;

    public Car() {
        position = 0;
    }

    public void moveForward() {
        position++;
    }

    public int getCurrentPosition() {
        return position;
    }
}
