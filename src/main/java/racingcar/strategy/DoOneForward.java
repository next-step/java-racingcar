package racingcar.strategy;

import racingcar.Constants;

import java.util.Random;

public class DoOneForward implements DoRace {

    @Override
    public int move() {
        if (forwardOkRandomCondition()) {
            return Constants.ONE_FORWARD;
        }
        return Constants.ZERO_FORWARD;
    }

    private boolean forwardOkRandomCondition(){
        /* Random Interface?? */
        return Constants.FORWARD_OK_COND_NUM <= Random.nextInt(Constants.RANDOM_BOUND);
    }

}
