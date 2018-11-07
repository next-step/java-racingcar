package racingcar;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<RacingGameResult> getLeadingRacingGameResults() {
        return racingGameResults.stream()
                .filter(result -> result.getPosition() == getMaxPosition())
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return racingGameResults.stream().
                collect(Collectors.summarizingInt(RacingGameResultSet.RacingGameResult::getPosition))
                .getMax();
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
