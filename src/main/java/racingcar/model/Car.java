package racingcar.model;

import racingcar.module.MovingStrategy;

public class Car {
    private int position = 0;

    public int getPosition() {
        return position;
    }


    public void move(MovingStrategy movingStrategy){
        if (movingStrategy.isMove()) {
            position++;
        }
    }
}
