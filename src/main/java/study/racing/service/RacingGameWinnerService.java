package study.racing.service;

import study.racing.domain.*;
import study.racing.strategy.RacingMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameWinnerService {

    private final CarRaceInput carRaceInput;
    private Cars cars;

    public RacingGameWinnerService(CarRaceInput carRaceInput) {
        this.carRaceInput = carRaceInput;
        this.cars = Cars.initOfCar(carRaceInput);
    }

    public RacingHistory raceStart(RacingMoveStrategy racingMoveStrategy) {
        RacingHistory racingHistory = new RacingHistory();
        for(int i = 0; i < carRaceInput.getRoundCount(); i++) {
            moveCar(racingMoveStrategy);
            racingHistory.saveHistory(cars.getCarList());
        }
        racingHistory.setSize(carRaceInput.getRoundCount());
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

    public List<Car> findWinners(RacingHistory racingHistory) {
        List<Car> winners = new ArrayList<>();
        List<List<Car>> carList = racingHistory.getCars();
        int roundCount = carRaceInput.getRoundCount();

        for(int i = 0; i < roundCount; i++) {
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
