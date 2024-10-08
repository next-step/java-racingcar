package study.racing.service;

import study.racing.domain.*;
import study.racing.strategy.RacingMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameWinnerService {

    private final Input input;
    private Cars cars;

    public RacingGameWinnerService(Input input) {
        this.input = input;
        this.cars = Cars.initOfCar(input);
    }

    public RacingHistory raceStart(RacingMoveStrategy racingMoveStrategy) {
        RacingHistory racingHistory = new RacingHistory();
        for(int i = 0; i < input.getRoundCount(); i++) {
            moveCar(racingMoveStrategy);
            racingHistory.saveHistory(cars.getCarList());
        }
        racingHistory.setSize(input.getRoundCount());
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

    public List<Winner> findWinners(RacingHistory racingHistory) {
        List<Winner> winners = new ArrayList<>();
        List<List<Car>> carList = racingHistory.getCars();
        int roundCount = input.getRoundCount();

        for(int i = 0; i < roundCount; i++) {
            List<Car> cars = carList.get(i);
            winners = findMaxMoveCount(cars);
        }

        return winners;
    }

    private List<Winner> findMaxMoveCount(List<Car> cars) {

        int maxMoveCount = cars.get(0).getMoveCount();
        for(Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }
        return addWinners(maxMoveCount, cars);
    }

    private List<Winner> addWinners(int maxMoveCount, List<Car> cars) {
        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(car -> {
                    Winner winner = new Winner();
                    winner.setWinnerName(car.getCarName());
                    return winner;
                })
                .collect(Collectors.toList());
    }

}
