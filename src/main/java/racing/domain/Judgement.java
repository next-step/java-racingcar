package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Judgement {

    private static final int FIRST_INDEX = 0;

    private final List<CarResult> lastResult;
    private final int bestDistance;

    public Judgement(List<CarResult> lastResult) {
        this.lastResult = lastResult;
        this.bestDistance = getBestDistance();
    }

    private int getBestDistance() {
        lastResult.sort(CarResult::compareTo);
        return lastResult.get(FIRST_INDEX).getDistance();
    }

    public List<String> judgeWinner() {
        return lastResult.stream()
            .filter(carResult -> carResult.isSameDistance(bestDistance))
            .map(CarResult::getName)
            .collect(Collectors.toList());
    }
}
