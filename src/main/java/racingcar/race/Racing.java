package racingcar.race;

import racingcar.DiceRacingRule;
import racingcar.RacingDice;

import java.util.List;

public class Racing {

    private static final RacingRule DEFAULT_RACING_RULE = new DiceRacingRule(RacingDice.newInstance());

    private final CarsJoinRacing racingCar;
    private final RacingRule racingRule;
    private final int raceTime;

    private Racing(RacingRule racingRule, String carNames, int raceTime) {
        checkRacingCount(raceTime);

        this.raceTime = raceTime;
        this.racingRule = racingRule;
        this.racingCar = CarsJoinRacing.newInstance(carNames);
    }

    private Racing(RacingRule racingRule, CarsJoinRacing carsJoinRacing, int raceTime) {
        this.raceTime = raceTime;
        this.racingRule = racingRule;
        this.racingCar = carsJoinRacing;
    }

    public static Racing applyRacing(String carNames, int raceTime) {
        return applyRacing(DEFAULT_RACING_RULE, carNames, raceTime);
    }

    public static Racing applyRacing(RacingRule racingRule, String carNames, int raceTime) {
        return new Racing(racingRule == null ? DEFAULT_RACING_RULE : racingRule, carNames, raceTime);
    }

    public static Racing applyRacing(RacingRule racingRule, CarsJoinRacing racingCar, int raceTime) {
        return new Racing(racingRule == null ? DEFAULT_RACING_RULE : racingRule, racingCar, raceTime);
    }

    public void start(GameResultReceiver receiver) {
        for(int i = 0 ; i < raceTime ; i++) {
            racingCar.race(racingRule);
            receiver.notifyFinishRace(racingCar.getRaceResult());
        }
    }

    public List<RacingScoreCard> getWinner() {
        return racingCar.getWinner();
    }

    private void checkRacingCount(int racingCount) {
        if(racingCount <= 0) {
            throw new IllegalArgumentException("The number of racingCount must be at least 1.");
        }
    }
}
