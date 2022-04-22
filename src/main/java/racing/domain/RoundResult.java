package racing.domain;

import racing.domain.RacingCar.Name;
import racing.util.Delimiter;
import racing.view.ResultView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RoundResult {

    private final Map<Name, String> roundResult;

    public RoundResult() {
        this.roundResult = new LinkedHashMap<>();
    }

    public Map<Name, String> getRoundResult() {
        return this.roundResult;
    }

    public void record(RacingCar racingCar, int rouletteResult) {
        this.roundResult.put(racingCar.getName(), racingCar.stopOrForward(rouletteResult).symbol);
    }

    public RoundResult printAndCombined(RoundResult roundResult) {
        this.printResultsByName();
        return this.combined(roundResult);
    }

    public RoundResult combined(RoundResult roundResult) {
        this.roundResult.forEach((name, result) ->
                roundResult.getRoundResult().compute(name, (n, afterResult) -> result + afterResult));

        return roundResult;
    }

    public RoundResult printResultsByName() {
        String resultsByName = this.roundResult.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .collect(Collectors.joining(Delimiter.NEW_LINE.symbol));
        ResultView.printMessage(resultsByName + Delimiter.NEW_LINE.symbol);

        return this;
    }

    public List<Name> getWinners() {
        int maxForward = this.roundResult
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(roundResult -> roundResult.getValue().length())
                .orElseThrow();

        return this.roundResult
                .entrySet()
                .stream()
                .filter(result -> Objects.equals(result.getValue().length(), maxForward))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
