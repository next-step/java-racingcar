package racingcar.strategy;

import racingcar.Constants;

import java.util.Random;

public class ForwardStrategy implements RacingStrategy {

    @Override
    public int move() {
        if (!forwardOkRandomCondition()) {
            return Constants.STOP;
        } return Constants.FORWARD;
    }

    public boolean forwardOkRandomCondition(){
        return Random.nexInt(10) >= Constants.FORWARD_OK_COND_NUM;
    }
}
