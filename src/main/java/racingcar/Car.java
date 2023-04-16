package racingcar;

public class Car {

    private static final int MOVABLE_COUNT = 4;

    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (movable(number)) {
            position++;
        }
    }

    private boolean movable(int number) {
        return number >= MOVABLE_COUNT;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
