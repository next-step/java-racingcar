package racingcar.domain;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int GO_STOP_DIVISION_POINT = 4;
    private int position;

    public Car() {
        this.position = INITIAL_POSITION;
    }

    public Car(Car car) {
        this.position = car.position;
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
        return condition < 0 || condition > 9;
    }

    private void go() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }
}
