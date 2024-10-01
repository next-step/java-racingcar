package racinggame.racingcar;

public class CarPosition {
    private int value;

    public CarPosition() {
        this.value = 0;
    }

    public boolean isAtStart() {
        return value == 0;
    }

    public void moveForward() {
        value++;
    }

    int getCurrentValue() {
        return value;
    }
}
