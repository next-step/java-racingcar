package racingcar.race;

import racingcar.DiceRacingRule;
import racingcar.RacingDice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private static final RacingRule DEFAULT_RACING_RULE = new DiceRacingRule(RacingDice.newInstance());

    private final List<Car> cars;
    private final RacingRule racingRule;
    private int raceTime;

    private Racing(RacingRule racingRule, List<Car> carList, int raceTime) {
        checkRacingCount(raceTime);

        this.raceTime = raceTime;
        this.racingRule = racingRule;
        this.cars = carList;
    }

    public static Racing applyRacing(List<Car> carList, int raceTime) {
        return applyRacing(DEFAULT_RACING_RULE, carList, raceTime);
    }

    public static Racing applyRacing(RacingRule racingRule, List<Car> carList, int raceTime) {
        return new Racing(racingRule == null ? DEFAULT_RACING_RULE : racingRule, carList, raceTime);
    }

    public void start(GameResultReceiver receiver) {
        for(int i = 0 ; i < raceTime ; i++) {
            race();
            receiver.notifyFinishRace(getRaceResult());
        }
    }

    private void checkRacingCount(int racingCount) {
        if(racingCount <= 0) {
            throw new IllegalArgumentException("The number of racingCount must be at least 1.");
        }
    }

    private List<RacingScoreCard> getRaceResult() {
        return cars.stream().map(car ->
                new RacingScoreCard(car.getName(), car.getPosition())).collect(Collectors.toList());
    }

    public List<RacingScoreCard> getWinner() {
        final int maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition).get();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(car -> new RacingScoreCard(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    private void race() {
        for(Car car : cars) {
            car.drive(racingRule.getMoveForward());
        }
    }
}
