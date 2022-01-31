package racingcar.model.vo;

public class Car {

    private final String name;
    private final static int NUMBER_ZERO = 0;
    private final static String DELIMITER = " ";
    private int step;

    public Car(final String name) {
        this.name = name;
        this.step = NUMBER_ZERO;
    }

    public void moveForward() {
        this.step++;
    }

    public int getStep() {
        return step;
    }

    public String getName() {
        return name;
    }
}

