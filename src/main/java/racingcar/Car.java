package racingcar;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
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
