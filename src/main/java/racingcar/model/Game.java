package racingcar.model;

import racingcar.util.RandomNumberUtil;

import java.util.List;

public class Game {

    private final Cars cars;

    private final TrialCount trialCount;

    private final MovementChecker movementChecker;

    public Game(Cars cars, TrialCount trialCount, MovementChecker movementChecker) {
        this.cars = cars;
        this.trialCount = trialCount;
        this.movementChecker = movementChecker;
    }

    public Game(Cars cars, TrialCount trialCount) {
        this(cars, trialCount, new MovementChecker());
    }

    public List<CarLocationResult> play() {
        boolean canMove = movementChecker.canMove(RandomNumberUtil.generateRandomNumber());
        List<Integer> randomNumberList = RandomNumberUtil.generateRandomNumberList(cars.size());
        cars.move(movementChecker.checkMovableList(randomNumberList));
        return cars.getCarLocationResult();
    }

    public boolean hasNextTrial() {
        return trialCount.hasNextTrial();
    }

    public void increaseNextTrial() {
        trialCount.increaseNextTrial();
    }

}
