package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Judgement {

    private static final int FIRST_INDEX = 0;

    private final List<CarResult> lastRoundResult;
    private final int bestDistance;

    public Judgement(List<CarResult> lastRoundResult) {
        this.lastRoundResult = lastRoundResult;
        this.bestDistance = getBestDistance();
    }

    private int getBestDistance() {
        lastRoundResult.sort(CarResult::compareTo);
        return lastRoundResult.get(FIRST_INDEX).getDistance();
    }

    public List<String> judgeWinner() {
        return lastRoundResult.stream()
            .filter(carResult -> carResult.isSameDistance(bestDistance))
            .map(CarResult::getName)
            .collect(Collectors.toList());
    }
}
