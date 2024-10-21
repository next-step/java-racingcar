package study.racing.service;

import study.racing.domain.*;
import study.racing.strategy.RacingMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameWinnerService {

    public RacingHistory raceStart(CarRaceInput carRaceInput, RacingMoveStrategy racingMoveStrategy) {
        RacingHistory racingHistory = new RacingHistory();
        Cars cars1 = Cars.initOfCar(carRaceInput);

        for(int i = 0; i < carRaceInput.getRoundCount(); i++) {
            moveCar(cars1, racingMoveStrategy);
            racingHistory.saveHistory(cars1.getCarList());
        }

        racingHistory.setSize(carRaceInput.getRoundCount());
        return racingHistory;
    }

    private void moveCar(Cars cars, RacingMoveStrategy racingMoveStrategy) {
        for (Car car : cars.getCarList()) {
            int moveCount = goAndStop(racingMoveStrategy);
            car.move(moveCount);
        }
    }

    private int goAndStop(RacingMoveStrategy racingMoveStrategy) {
        return racingMoveStrategy.move();
    }

    public List<Car> findWinners(int carCount, RacingHistory racingHistory) {
        List<Car> winners = new ArrayList<>();
        List<List<Car>> carList = racingHistory.getCars();
        for(int i = 0; i < carCount; i++) {
            List<Car> cars = carList.get(i);
            winners = findMaxMoveCount(cars);
        }

        return winners;
    }

    private List<Car> findMaxMoveCount(List<Car> cars) {

        int maxMoveCount = cars.get(0).getMoveCount();
        for(Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }
        return addWinners(maxMoveCount, cars);
    }

    private List<Car> addWinners(int maxMoveCount, List<Car> cars) {
        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(car -> { return new Car.Builder()
                        .setCarName(car.getCarName())
                        .build();
                })
                .collect(Collectors.toList());
    }

}
