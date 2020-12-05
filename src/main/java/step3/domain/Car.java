package step3.domain;

import step3.domain.strategy.MovingStrategy;

public class Car {

    private int position;

    public void move(MovingStrategy<Boolean> movingStrategy) {
        if (movingStrategy.isMove()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
