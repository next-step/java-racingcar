package racingcar.model;

import racingcar.util.RandomNumberUtil;

import java.util.List;

public class Game {

    private final Cars cars;

    private final TrialCount trialCount;

    private final RuleChecker ruleChecker;

    public Game(Cars cars, TrialCount trialCount, RuleChecker ruleChecker) {
        this.cars = cars;
        this.trialCount = trialCount;
        this.ruleChecker = ruleChecker;
    }

    public Game(Cars cars, TrialCount trialCount) {
        this(cars, trialCount, new RuleChecker());
    }

    public List<CarLocationResult> getInitCarLocationResult() {
        return cars.getCarLocationResult();
    }

    public List<CarLocationResult> play() {
        List<Integer> randomNumberList = RandomNumberUtil.generateRandomNumberList(cars.size());
        cars.move(ruleChecker.checkRule(randomNumberList));
        return cars.getCarLocationResult();
    }

    public boolean hasNextTrial() {
        return trialCount.hasNextTrial();
    }

    public void increaseNextTrial() {
        trialCount.increaseNextTrial();
    }

    public List<CarName> getWinners() {
        return cars.getWinners();
    }

}
