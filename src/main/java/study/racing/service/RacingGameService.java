package study.racing.service;

import study.racing.domain.RacingHistory;
import study.racing.domain.Car;
import study.racing.domain.Cars;
import study.racing.strategy.RacingMoveStrategy;

public class RacingGameService {

    private Cars cars;
    private int roundCount;

    public RacingGameService(int carCount
                           , int roundCount) {
        this.cars = Cars.initOfCar(carCount);
        this.roundCount = roundCount;
    }

    public RacingHistory raceStart(RacingMoveStrategy racingMoveStrategy) {
        RacingHistory racingHistory = new RacingHistory();
        for(int i = 0; i < roundCount; i++) {
            moveCar(racingMoveStrategy);
            racingHistory.saveHistory(cars.getCarList());
        }
        racingHistory.setSize(roundCount);
        return racingHistory;
    }

    private void moveCar(RacingMoveStrategy racingMoveStrategy) {
        for (Car car : cars.getCarList()) {
            int moveCount = goAndStop(racingMoveStrategy);
            car.setMoveCount(car.getMoveCount() + moveCount);
        }
    }

    private int goAndStop(RacingMoveStrategy racingMoveStrategy) {
        return racingMoveStrategy.move();
    }

}
