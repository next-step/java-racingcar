package racing.service;

import racing.domain.Cars;
import racing.domain.MovableStrategy;

public class RacingService {

    private final MovableStrategy movableStrategy;

    public RacingService(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public RacingResult race(String carNames, int numberOfRounds) {
        Cars cars = Cars.of(carNames, movableStrategy);
        RacingResult racingResult = new RacingResult();
        for (int i = 0; i < numberOfRounds; i++) {
            cars.moveCars();
            racingResult.addRoundResult(RoundResult.of(Round.of(i + 1), cars.getCars()));
        }
        racingResult.reportWinners(cars.findWinners());
        return racingResult;
    }
}
