package step4.domain;

import java.util.*;

public class RacingGame {
    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public RacingGame(Cars cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public List<RoundStatusDTO>  playRound() {
        cars.moveAll(moveStrategy);
        return cars.getRoundStatusOfCars();
    }

    public List<RoundStatusDTO>  findWinners() {
        return cars.findWinnersStatus();
    }
}
