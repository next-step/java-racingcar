package racingcar;

public class Car {

    private final int MIN_DISTANCE = 4;
    private int position = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(int distance) {
        if (!checkMovable(distance)) {
            System.out.println();
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
        return MIN_DISTANCE  <= distance;
    }
}
