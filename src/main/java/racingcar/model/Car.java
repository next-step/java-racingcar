package racingcar.model;

import racingcar.model.action.RandomMovable;

public class Car {

    private int position;


    public void move() {
        position++;
    }

    public int getPoisition() {
        return position;
    }
}
