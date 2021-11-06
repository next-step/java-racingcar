package racingcar.moverule;

import racingcar.car.Car;
import utils.IntUtils;

public class RandomMoveRule implements MoveRule {

    private static final int FORWARD_COUNT = 1;
    private static final int FORWARD_STANDARD_VALUE = 4;

    public void move(Car car){
        if(moveForward()) car.forward(FORWARD_COUNT);
    }

    private boolean moveForward() {
        return IntUtils.getRandomUnder(10) >= FORWARD_STANDARD_VALUE;
    }
}