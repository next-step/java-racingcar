package racingcar.domain;

public class Car {

    private int position;
    private final String name;
    private static final int MOOVABLE_RANDOM_NUMBER = 4;

    public Car(String input) {
        this.name = input;
    }

    public int position() {
        return position;
    }

    public String name() {
        return name;
    }

    public void move(int input) {
        if (isMovable(input)) {
            position++;
        }
    }

    public boolean isMovable(int input) {
        return input >= MOOVABLE_RANDOM_NUMBER;
    }
}

