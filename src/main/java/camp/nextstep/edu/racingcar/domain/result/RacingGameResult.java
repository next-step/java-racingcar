package camp.nextstep.edu.racingcar.domain.result;

import camp.nextstep.edu.racingcar.domain.Winners;
import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {

    private List<RoundResult> roundResults;
    private List<String> winners;

    public RacingGameResult() {
        this.roundResults = new ArrayList<>();
    }

    public void report(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public List<RoundResult> roundResults() {
        return this.roundResults;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (RoundResult roundResult : roundResults) {
            result.append(roundResult.toString()).append('\n');
        }

        String winners = getWinners();
        result.append(winners).append("가 최종 우승했습니다.");

        return result.toString();
    }

    private String getWinners() {
        String[] winners = Winners.getWinners(roundResults.get(roundResults.size() - 1));
        return String.join(", ", winners);
    }
}
