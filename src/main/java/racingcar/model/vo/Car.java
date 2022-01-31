package racingcar.model.vo;

public class Car {

    private final static int NUMBER_ZERO = 0;
    private final String name;
    private int step;

    public Car(final String name) {
        this.name = name;
        this.step = NUMBER_ZERO;
    }

    public void moveForward() {
        this.step++;
    }

    public boolean isMax(final int max, final Car car) {
        return car.getStep() == max;
    }

    public int getStep() {
        return step;
    }

    public String getName() {
        return name;
    }
}

