package racingcar.domain;

public class Car {
    private static final int MINIMUM_NUMBER_TO_RUN = 4;
    private int position = 0;

    public boolean canRun(int randomNum) {
        return randomNum >= MINIMUM_NUMBER_TO_RUN;
    }

    public void move(boolean canRun) {
        if (canRun) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}