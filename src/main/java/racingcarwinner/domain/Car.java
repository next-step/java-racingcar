package racingcarwinner.domain;

import racingcarwinner.Exception.IllegalNameSizeException;
import racingcarwinner.strategy.MoveStrategy;

public class Car {
    private static final String POSITION_STRING = "-";
    private static final int NAME_MAX_LENGTH = 5;
    private static final int GO = 1;
    private final StringBuilder position;
    private final String name;
    private int currentPosition;

    public Car(String name) {
        assertValidName(name);
        this.name = name;
        position = new StringBuilder().append(name).append(" : ");
    }

    private String assertValidName(String name) {
        if(name.length() <= NAME_MAX_LENGTH)  return name;
        throw new IllegalNameSizeException();
    }

    public String getCarName() {
        return name;
    }

    public int getPositionNumber() {
        return currentPosition;
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.isMovable())    go();
    }

    private void go() {
        position.append(POSITION_STRING);
        currentPosition += GO;
    }

    @Override
    public String toString() {
        return position.toString();
    }

    public boolean isMaxPosition(int maxPosition) {
        return currentPosition == maxPosition;
    }

    public int isMax(int max) {
        return Math.max(max, currentPosition);
    }
}
