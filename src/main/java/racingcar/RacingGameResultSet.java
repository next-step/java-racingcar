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
        private int position;

        private RacingGameResult(int position) {
            this.position = position;
        }

        public static RacingGameResult of(int position) {
            return new RacingGameResult(position);
        }

        public int getPosition() {
            return position;
        }
    }
}
