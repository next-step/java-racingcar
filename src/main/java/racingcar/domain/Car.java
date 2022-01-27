package racingcar.domain;

public class Car {

    private final int MIN_DISTANCE = 4;
    private final String name;
    private int position = 0;


    public Car(String name) {
        this.name = name;
    }

    public void move(int distance) {
        if (!checkMovable(distance)) {
            return;
        }

        position += distance;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean checkMovable(int distance) {
        return MIN_DISTANCE <= distance;
    }
}
