package racingcar;

import java.util.List;
import java.util.Map;

public class RacingGameMock extends RacingGame {

    public RacingGameMock(int carCount, int moveCount, Map<Integer, List<RacingCar>> racingCarMap) {
        super(carCount, moveCount);
        setRacingCarMap(racingCarMap);
    }

}
