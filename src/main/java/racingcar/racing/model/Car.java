package racingcar.racing.model;

import racingcar.racing.Movable;

public class Car implements Movable {

    private final int id;

    private int xCoordinate;


    public Car(int id, int xCoordinate) {
        this.id = id;
        this.xCoordinate = xCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getId() {
        return id;
    }

    @Override
    public void forward(boolean value) {
        if(value) {
            xCoordinate++;
        }
    }

}
