package racingcarwinner.domain;

import racingcarwinner.Exception.IllegalNameSizeException;
import racingcarwinner.strategy.MoveStrategy;

public class Car {
    private static final String POSITION_STRING = "-";
    private StringBuilder position;
    private final String name;

    public Car(String name) {
        this.name = isLessThanFive(name);
        position = new StringBuilder();
    }

    private String isLessThanFive(String name) {
        if(name.length() <= 5)  return name;
        throw new IllegalNameSizeException();
    }

    public String getPosition() {
        return position.toString();
    }

    public String getCarName() {
        return name;
    }

    public int getPositionNumber() {
        return position.length();
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.isMovable())    go();
    }

    private void go() {
        position.append(POSITION_STRING);
    }

    @Override
    public String toString() {
        return new StringBuilder(name).append(" : ").append(position.toString()).toString();
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.length() == maxPosition;
    }

    public int isEqualMax(int max) {
        if(max < getPositionNumber())   return getPositionNumber();
        return max;
    }
}
