package racingcar.domain;

public class Car {
    private static final int CAR_STEP_LIMIT = 4;
    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    public void step(final int number) {
        if (number >= CAR_STEP_LIMIT)
            this.position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
