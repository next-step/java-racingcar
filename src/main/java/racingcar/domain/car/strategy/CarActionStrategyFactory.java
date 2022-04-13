package racingcar.domain.car.strategy;

import racingcar.utils.RandomUtils;

import java.util.Map;

public class CarActionStrategyFactory {
    private final static int MAX_ACTION_NO = 9;
    private final static int STOP_LIMIT = 4;

    private static final Map<CarAction, CarActionStrategy> strategyMap = Map.of(
            CarAction.GO_FORWARD, new MoveStrategy(),
            CarAction.STOP, new StopStrategy()
    );

    public static CarActionStrategy resolve() {
        return resolve(RandomUtils.getRandomPositiveInt(MAX_ACTION_NO));
    }

    public static CarActionStrategy resolve(int actionNo) {
        return strategyMap.get(decideAction(actionNo));
    }

    private static CarAction decideAction(int actionNo) {
        if (actionNo < STOP_LIMIT) {
            return CarAction.STOP;
        }
        return CarAction.GO_FORWARD;
    }
}
