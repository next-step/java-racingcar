package game.domain;

import game.util.ResultView;

public class Car {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;
    private static final int MINIMUM_MOVEMENT_NUMBER = 4;
    private int distance = 1;

    public int getDistance() {
        return distance;
    }

    public void printDistance() {
        ResultView.printPlainMessage("-".repeat(Math.max(0, distance)));
    }

    public void move(int number) {
        validateNumber(number);
        if (canMove(number)) {
            distance += 1;
        }
    }

    private void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new RuntimeException();
        }
    }

    private boolean canMove(int number) {
        return number >= MINIMUM_MOVEMENT_NUMBER;
    }
}
