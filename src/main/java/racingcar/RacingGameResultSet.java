package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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

    // 이 역할은 ResultView 에서 해야하는 것은 아닐까?
    public String getRacingGameWinner() {
        return getWinnerRacingGameResults().stream()
                .map(RacingGameResult::getName)
                .collect(Collectors.joining(", "));
    }

    private List<RacingGameResult> getWinnerRacingGameResults() {
        return racingGameResults.stream()
                .filter(result -> result.isRanking(calculateMaxPosition()))
                .collect(toList());
    }

    private int calculateMaxPosition() {
        return Collections.max(racingGameResults.stream()
                .map(RacingGameResult::getPosition)
                .collect(toList()));
    }

    public static class RacingGameResult {
        private String name;
        private int position;

        private RacingGameResult(RacingCar racingCar) {
            this.name = racingCar.getName();
            this.position = racingCar.getPosition();
        }

        private RacingGameResult(String name, int position) {
            this.name = name;
            this.position = position;
        }

        public static RacingGameResult of(RacingCar racingCar) {
            return new RacingGameResult(racingCar);
        }

        public static RacingGameResult of(String name, int position) {
            return new RacingGameResult(name, position);
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        public boolean isRanking(int maxPosition) {
            return maxPosition <= this.position;
        }
    }
}
