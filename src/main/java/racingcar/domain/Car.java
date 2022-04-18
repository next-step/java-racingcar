package racingcar.domain;

public class Car {

    private static final int BOUNDARYVALUE= 4;
    private int movement = 0;

    public int moveOrStop(int value) {
        if (value >= BOUNDARYVALUE) {
            movement++;
        }
        return movement;
    }

    public int getMovement() {
        return movement;
    }
}
