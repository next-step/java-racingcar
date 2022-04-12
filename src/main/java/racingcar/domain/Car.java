package racingcar.domain;

public class Car {
    private int movement = 0;
    private static final int BOUNDARYVALUE= 4;

    public int moveOrStop(int value) {
        if (value >= BOUNDARYVALUE) {
            movement++;
        }
        return movement;
    }
}
