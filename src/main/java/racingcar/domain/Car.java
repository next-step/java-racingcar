package racingcar.domain;

import racingcar.domain.input.CarName;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int GO_STOP_DIVISION_POINT = 4;
    private static final int BOUND_MIN = 0;
    private static final int BOUND_MAX = 9;
    private int position;
    private final CarName carName;

    public Car(String carName) {
        this.position = INITIAL_POSITION;
        this.carName = new CarName(carName);
    }

    public Car(CarName carName) {
        this.position = INITIAL_POSITION;
        this.carName = carName;
    }

    public Car(Car car) {
        this.position = car.position;
        this.carName = car.carName;
    }

    public void stopOrGo(int condition) {
        if (isOutOfBound(condition)) {
            throw new IllegalArgumentException();
        }
        if (isStop(condition)) {
            return;
        }
        go();
    }

    private boolean isStop(int condition) {
        return condition < GO_STOP_DIVISION_POINT;
    }

    private boolean isOutOfBound(int condition) {
        return condition < BOUND_MIN || condition > BOUND_MAX;
    }

    private void go() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car)) {
            return false;
        }
        Car c = (Car) obj;
        return c.carName.equals(carName) && c.position == (position);
    }
}
