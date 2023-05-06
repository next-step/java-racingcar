package racinggame.domain;

import racinggame.common.util.RandomUtils;
import racinggame.exception.OverCarNameLengthException;

public class Car {

    private static final int MINIMUM_NUMBER_FOR_MOVE = 4;

    private final int number;

    private final String name;

    private int moveCount = 0;

    public Car(int number, String name) {
        this.number = number;
        if (name.length() > 5) throw new OverCarNameLengthException();
        this.name = name;
    }

    public void move() {
        if (canMove(RandomUtils.generate())) {
            moveCount++;
        }
    }

    boolean canMove(int randomValue) {
        return randomValue > MINIMUM_NUMBER_FOR_MOVE;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
