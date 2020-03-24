package racingcar;

public class Car {

    private int position;

    public Car() {
        position = 0;
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
