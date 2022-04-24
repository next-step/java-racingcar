package racingcarwinner.domain;

import racingcarwinner.Exception.IllegalNameSizeException;
import racingcarwinner.strategy.MoveStrategy;

public class Car {
    private static final String POSITION_STRING = "-";
    private final StringBuilder position;
    private final String name;
    private int currentPosition;

    public Car(String name) {
        this.name = assertNameSize(name);
        position = new StringBuilder().append(name).append(" : ");
    }

    private String assertNameSize(String name) {
        if(name.length() <= 5)  return name;
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
        currentPosition += 1;
    }

    @Override
    public String toString() {
        return position.toString();
    }

    public boolean isMaxPosition(int maxPosition) {
        return currentPosition == maxPosition;
    }

    public int isMax(int max) {
        if(max < currentPosition)   return currentPosition;
        return max;
    }
}
