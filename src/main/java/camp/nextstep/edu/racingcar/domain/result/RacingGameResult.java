package camp.nextstep.edu.racingcar.domain.result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {

    private List<RoundResult> roundResults;
    private List<String> winners;

    public RacingGameResult() {
        this.roundResults = new ArrayList<>();
    }

    public void report(RoundResult roundResult) {
        roundResults.add(roundResult);
        this.winners = roundResult.getWinners();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (RoundResult roundResult : roundResults) {
            result.append(roundResult.toString()).append('\n');
        }

        result.append(String.join(", ", winners))
            .append("가 최종 우승했습니다.");

        return result.toString();
    }

    public List<RoundResult> roundResults() {
        return this.roundResults;
    }
}
