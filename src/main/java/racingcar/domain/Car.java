package racingcar.domain;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int GO_STOP_DIVISION_POINT = 4;
    private int position;

    public Car() {
        this.position = INITIAL_POSITION;
    }

    public void stopOrGo(int condition) {
        if (condition < GO_STOP_DIVISION_POINT) {
            return;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
