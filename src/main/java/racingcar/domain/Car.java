package racingcar.domain;

public class Car {

    private final String name;
    private int step;

    private Car(final String name) {
        this.name = name;
        this.step = 0;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public void MoveForward() {
        this.step++;
    }

    public int getStep() {
        return step;
    }
}
