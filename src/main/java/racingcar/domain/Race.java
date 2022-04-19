package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.module.ResultView;

public class Race {
    private int raceCount;
    private List<RacingCar> racingCars;

    private Race(int raceCount, List<RacingCar> racingCars) {
        this.raceCount = raceCount;
        this.racingCars = racingCars;
    }

    public void startRace() {
        ResultView.printResultMessage();
        for (int i = 0; i < raceCount; i++) {
            oneRound();
            ResultView.printNextRound();
        }
        ResultView.printWinners(getWinners());
    }

    private void oneRound() {
        racingCars.forEach(
            racingCar -> {
                int position = racingCar.moveOrStop();
                ResultView.printPosition(racingCar.getName(), position);
            }
        );
    }

    public List<String> getWinners() {
        int winnerPosition = racingCars.stream().mapToInt(RacingCar::getPosition).max()
                .orElseThrow(RuntimeException::new);
        return racingCars.stream().filter(it -> it.getPosition() == winnerPosition)
                .map(RacingCar::getName).collect(Collectors.toList());
    }

    public static class RaceBuilder {
        private static final int INT_RANGE = 10;
        private static final int MOVE_CONDITION = 4;

        private List<String> carNames;
        private int raceCount;
        private Condition condition = new RaceCondition(INT_RANGE, MOVE_CONDITION);

        public RaceBuilder setCarNames(List<String> carNames) {
            this.carNames = carNames;
            return this;
        }

        public RaceBuilder setRaceCount(int raceCount) {
            this.raceCount = raceCount;
            return this;
        }

        public RaceBuilder setCondition(Condition condition) {
            this.condition = condition;
            return this;
        }

        public Race build() {
            List<RacingCar> racingCars = carNames.stream().map(it -> new RacingCar(it, condition)).collect(Collectors.toList());

            return new Race(raceCount, racingCars);
        }
    }
}
