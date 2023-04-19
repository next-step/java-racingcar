package racing.model;

import racing.model.move.MoveStrategy;
import racing.util.RandomUtil;

public class Car {

    private int position;

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

}
