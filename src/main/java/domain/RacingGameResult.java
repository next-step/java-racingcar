package domain;

import view.RacingGameResultFormatter;
import view.RoundResultFormatter;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private final List<RoundResult> roundResults;

    public RacingGameResult() {
        this.roundResults = new ArrayList<>();
    }

    public void addRoundResult(RoundResult roundResult) {
        this.roundResults.add(roundResult);
    }

    public RacingGameResultFormatter generateFormatter() {
        List<RoundResultFormatter> formatters = new ArrayList<>();
        for (RoundResult roundResult : roundResults) {
            formatters.add(roundResult.generateFormatter());
        }
        return new RacingGameResultFormatter(formatters);
    }

    public RoundResult getLastRoundResult() {
        return roundResults.get(roundResults.size() - 1);
    }

    public List<String> whoAreWinners() {
        RoundResult lastRoundResult = getLastRoundResult();
        return lastRoundResult.findWinners();
    }


}
