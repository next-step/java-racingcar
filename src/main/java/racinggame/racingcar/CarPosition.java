package racinggame.racingcar;

public class CarPosition {
    private int value;

    CarPosition() {
        this.value = 0;
    }

    boolean isAtStart() {
        return value == 0;
    }

    void moveForward() {
        value++;
    }
}
