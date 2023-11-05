package racingcar.domain;

public class Car {

    private int position;
    private static final int MOOVABLE_RANDOM_NUMBER = 4;

    public Car() {
    }

    public Car(int input) {
        this.position = input;
    }

    public int position() {
        return position;
    }

    public void move(int input) {
        if(isMovable(input)) {
            position++;
        }
    }
    public boolean isMovable(int input) {
        return input >= MOOVABLE_RANDOM_NUMBER;
    }
}

