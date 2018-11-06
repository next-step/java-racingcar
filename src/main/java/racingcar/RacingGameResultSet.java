package racingcar;

import java.util.List;

public class RacingGameResultSet {

    private List<RacingGameResult> racingGameResults;

    private RacingGameResultSet(List<RacingGameResult> racingGameResults) {
        this.racingGameResults = racingGameResults;
    }

    public static RacingGameResultSet of(List<RacingGameResult> racingGameResults) {
        return new RacingGameResultSet(racingGameResults);
    }

    public List<RacingGameResult> getRacingGameResults() {
        return racingGameResults;
    }

    public static class RacingGameResult {
        private String name;
        private int position;

        private RacingGameResult(RacingCar racingCar) {
            this.name = racingCar.getName();
            this.position = racingCar.getPosition();
        }

        public static RacingGameResult of(RacingCar racingCar) {
            return new RacingGameResult(racingCar);
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }
    }
}
