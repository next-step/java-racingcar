package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.CarResult;
import racing.domain.RoundResult;

public class Judgement {

    private static final int FIRST_INDEX = 0;
    private final List<CarResult> result;
    private final int bestDistance;

    public Judgement(RoundResult result) {
        this.result = result.getResultVOS();
        this.bestDistance = getBestDistance();
    }

    private int getBestDistance() {
        result.sort(CarResult::compareTo);
        return result.get(FIRST_INDEX).getDistance();
    }

    public List<String> judgeWinner() {
        return result.stream()
            .filter(result -> result.isSameDistance(bestDistance))
            .map(CarResult::getName)
            .collect(Collectors.toList());
    }
}
