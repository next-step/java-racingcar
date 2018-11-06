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

    public void showPositions() {
        // TODO
        // 이 역할을 RacingGameResultSet 하는게 맞을까 아니면 ResultView 에서 하는게 맞을까...
        racingGameResults.forEach(RacingGameResult::showPosition);
        System.out.println();
    }

    public static class RacingGameResult {
        private int position;

        private RacingGameResult(int position) {
            this.position = position;
        }

        public static RacingGameResult of(int position) {
            return new RacingGameResult(position);
        }

        public void showPosition() {
            System.out.println(StringUtils.convertToHyphen(this.position));
        }
    }
}
