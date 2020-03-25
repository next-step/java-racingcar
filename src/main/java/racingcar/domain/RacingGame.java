package racingcar.domain;

import racingcar.util.NumberUtils;

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
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public List<RacingResult> startRaceAndReduceCount() {
        reduceCount();
        return this.startRace();
    }

    public List<String> findWinnerNames() {
        return new RacingWinner(cars).findWinnerNames();
    }

    public boolean canRace() {
        return this.raceTime > NumberUtils.ZERO;
    }

    private List<RacingResult> startRace() {
        return cars.stream()
                .map(i -> move(i))
                .collect(Collectors.toList());
    }

    private RacingResult move(RacingCar car) {
        if (canMove()) {
            car.moveForward();
        }
        return new RacingResult(car);
    }

    private void reduceCount() {
        this.raceTime = raceTime - NumberUtils.REDUCE_STEP;
    }

    private boolean canMove() {
        return NumberUtils.getRandom() > NumberUtils.MOVABLE_NUMBER;
    }

}
