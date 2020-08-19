package racingcar.strategy;

import static racingcar.Constants.*;

public class DoOneForward implements DoRace {

    int position;

    @Override
    public int race() {
            return position += ONE_FORWARD;}
}
