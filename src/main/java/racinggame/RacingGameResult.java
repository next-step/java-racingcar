package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGameResult {

    private final List<RacingGameRoundResult> result;

    public RacingGameResult() {
        this.result = new ArrayList<>();
    }

    public RacingGameResult(List<RacingGameRoundResult> result) {
        this.result = result;
    }

    public void add(RacingGameRoundResult roundResult) {
        result.add(roundResult);
    }

    public String getContent() {
        return result.stream()
                .map(RacingGameRoundResult::getContent)
                .collect(Collectors.joining(StringConstants.NEW_LINE));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGameResult that = (RacingGameResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    public List<String> getWinnerNames() {
        RacingGameRoundResult lastRound = result.get(result.size() - 1);
        return lastRound.getFarthestCarNames();
    }
}
