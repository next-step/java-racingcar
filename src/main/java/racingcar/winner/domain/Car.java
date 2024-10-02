package racingcar.winner.domain;

public class Car {

    private static final int RANDOM_THRESHOLD = 4;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int randomNumber) {
        if (movable(randomNumber)) {
            position++;
        }
    }

    private boolean movable(int randomNumber) {
        return randomNumber >= RANDOM_THRESHOLD;
    }
}
