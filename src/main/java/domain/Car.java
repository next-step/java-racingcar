package domain;

import utils.RandomNumber;

public class Car {
    private static final String DASH = "-";
    private final int CONDITION_OF_MOVE = 4;
    private int countOfMove;

    public void move() {
        if(!canMove()) {
            return;
        }
        countOfMove++;
    }

    private Boolean canMove() {
        int randomNumber = RandomNumber.generate();
        if (randomNumber < CONDITION_OF_MOVE) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DASH.repeat(Math.max(0, countOfMove)));
        return sb.toString();
    }
}
