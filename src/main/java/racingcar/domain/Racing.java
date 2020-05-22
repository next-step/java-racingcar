package racingcar.domain;

import racingcar.DiceRacingRule;
import racingcar.RacingDice;

import java.util.List;
import java.util.Objects;

public class Racing {

    private static final RacingRule DEFAULT_RACING_RULE = new DiceRacingRule(RacingDice.newInstance());

    private final CarsJoinRacing racingCar;
    private final RacingRule racingRule;
    private final int raceTime;

    private Racing(Builder builder) {
        checkRacingCount(builder.raceTime);

        this.raceTime = builder.raceTime;
        this.racingRule = builder.racingRule;
        this.racingCar = builder.racingCar;
    }

    public static class Builder {
        private final int raceTime;
        private final CarsJoinRacing racingCar;

        private RacingRule racingRule = DEFAULT_RACING_RULE;

        public Builder(String carNames, int raceTime) {
            this.raceTime = raceTime;
            this.racingCar = CarsJoinRacing.newInstance(carNames);;
        }

        public Builder(CarsJoinRacing racingCar, int raceTime) {
            this.raceTime = raceTime;
            this.racingCar = racingCar;
        }

        public Builder racingRule(RacingRule racingRule) {
            this.racingRule = Objects.requireNonNull(racingRule);
            return this;
        }

        public Racing build() {
            return new Racing(this);
        }
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
