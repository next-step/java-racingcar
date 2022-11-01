package race.domian;

import race.strategy.MoveStrategy;
import race.ui.ResultView;

public class Car {

    private int position;
    public static final int START_POSITION = 0;
    public static final int DISTANCE_TO_MOVE_AT_ONCE = 1;


    public Car() {
        this.position = START_POSITION;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position += DISTANCE_TO_MOVE_AT_ONCE;
        }
        ResultView.printPosition(getPosition());
    }

    public int getPosition() {
        return position;
    }
}
