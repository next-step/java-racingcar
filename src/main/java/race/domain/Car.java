package race.domain;

import utils.RandomNumber;

public class Car {
    private final int CONDITION_OF_MOVE = 4;
    private int countOfMove;

    public void move() {
        if(!canMove()) {
            return;
        }
        countOfMove++;
    }

    private Boolean canMove() {
        return RandomNumber.generate() >= CONDITION_OF_MOVE;
    }

    public int getCountOfMove() {
        return countOfMove;
    }
}
