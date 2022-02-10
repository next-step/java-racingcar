package racingcar.model.domain;

public class Car {

    private final static int NUMBER_ZERO = 0;
    private final String name;
    private int step;

    public Car(final String name) {
        this.name = name;
        this.step = NUMBER_ZERO;
        validateCarName(name);
    }

    private void validateCarName(String name) {
        if(name.length() > 5)
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    public void moveForward() {
        this.step++;
    }

    public boolean isMax(final int max) {
        return this.step == max;
    }

    public int getStep() {
        return step;
    }

    public String getName() {
        return name;
    }
}

