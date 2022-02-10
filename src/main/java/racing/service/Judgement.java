package racing.service;

import java.util.List;
import java.util.stream.Collectors;
import racing.vo.CarResultVO;
import racing.domain.RoundResult;

public class Judgement {

    private static final int FIRST_INDEX = 0;
    private final List<CarResultVO> result;
    private final int bestDistance;

    public Judgement(RoundResult result) {
        this.result = result.getResultVOS();
        this.bestDistance = getBestScore();
    }

    private int getBestScore() {
        result.sort(CarResultVO::compareTo);
        return result.get(FIRST_INDEX).getDistance();
    }

    public List<String> judgeWinner() {
        return result.stream()
            .filter(result -> result.isSameDistance(bestDistance))
            .map(CarResultVO::getName)
            .collect(Collectors.toList());
    }
}
