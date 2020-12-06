package step4.domain;

import step4.domain.strategy.MovingStrategy;

public class Car {

    private int position;

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
