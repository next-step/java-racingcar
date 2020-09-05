package racingcar.domain.car.strategy.raceStrategy;

import static racingcar.domain.game.utils.Constants.*;

public class DoOneForward implements DoRace {
    
    @Override
    public int race() {
            return ONE_FORWARD;}
}
