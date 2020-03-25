package racingcar.domain;

import racingcar.util.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<RacingCar> cars;
    private int raceTime;

    public RacingGame(String[] carNames, int raceTime) {
        createCar(carNames);
        this.raceTime = raceTime;
    }

    private void createCar(String[] carNames) {
        cars = Arrays.stream(carNames)
                .map(carName -> new RacingCar(carName))
                .collect(Collectors.toList());
    }

    public List<RacingResult> start() {
            return moveCars();
    }

    public List<String> findWinnerNames() {
        RacingWinner winners = new RacingWinner(cars);
        return winners.findWinnerNames();
    }

    public boolean canRace() {
        return this.raceTime > NumberUtils.ZERO;
    }

    private List<RacingResult> moveCars() {
        List<RacingResult> racingResults = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            racingResults.add(move(cars.get(i)));
        }
        return racingResults;
    }

    private RacingResult move(RacingCar car) {
        if (canMove()) {
            car.moveForward();
        }
        return new RacingResult(car);
    }

    public void reduceCount() {
        this.raceTime = raceTime - 1;
    }

    private boolean canMove() {
        return NumberUtils.getRandom() > NumberUtils.MOVABLE_NUMBER;
    }

}
