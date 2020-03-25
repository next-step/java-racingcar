package racingcar.domain;

import racingcar.infrastructure.DefaultMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int round;

    public RacingGame(List<String> carNames, int round) {
        this.cars = new Cars(carNames);
        this.round = round;
    }

    public List<Cars> start() {
        List<Cars> roundResults = new ArrayList<>();
        for (int i = RacingGameConstant.NUMBER_ZERO; i < round; i++) {
            roundResults.add(cars.moveAllCar(new DefaultMoveStrategy()));
        }
        return roundResults;
    }

}
