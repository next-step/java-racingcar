package racinggame.domain.racingcar;

public class CarPosition {
    private int value;

    public CarPosition() {
        this.value = 0;
    }

    public void moveForward() {
        value++;
    }

    int getCurrentValue() {
        return value;
    }
}
