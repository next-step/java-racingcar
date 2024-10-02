package racing.model.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racing.model.CarInfo;
import racing.model.RoundResult;

public class GameResult {
    private final List<RoundResult> roundResults;

    public GameResult() {
        this.roundResults = new ArrayList<>();
    }

    public void addRoundResult(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public List<RoundResult> getRoundResults() {
        return Collections.unmodifiableList(roundResults);
    }

    public List<String> getWinners() {
        if (roundResults.isEmpty()) {
            return Collections.emptyList();
        }
        RoundResult finalRoundResult = getFinalRoundResult();
        int maxPosition = getMaxPosition(finalRoundResult);
        return extractWinnerNames(finalRoundResult, maxPosition);
    }

    private RoundResult getFinalRoundResult() {
        return roundResults.get(roundResults.size() - 1);
    }

    private int getMaxPosition(RoundResult finalRoundResult) {
        return finalRoundResult.getCarInfos()
                .stream()
                .mapToInt(CarInfo::getPosition)
                .max()
                .orElse(0);
    }

    private List<String> extractWinnerNames(RoundResult finalRoundResult, int maxPosition) {
        return finalRoundResult.getCarInfos()
                .stream()
                .filter(carInfo -> carInfo.getPosition() == maxPosition)
                .map(CarInfo::getName)
                .collect(Collectors.toList());
    }
}
