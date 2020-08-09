package racingcar.strategy;

import static racingcar.Constants.*;

public class DoOneForward implements DoRace {

    int position;
    OneForwardCondition oneForwardCondition = new OneForwardCondition();

    @Override
    public int race() {
        if (oneForwardCondition.pass()) {
            return position += ONE_FORWARD;
        }
        return position += ZERO_FORWARD;
    }
}
