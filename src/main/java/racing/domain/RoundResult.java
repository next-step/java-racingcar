package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {
    private final List<Car> roundResult;

    public RoundResult(List<Car> result) {
        this.roundResult = result;
    }

    public List<Car> getRoundResult() {
        return roundResult;
    }

    public List<Car> findWinners() {
        int winnerPosition = findWinnerPosition();
        return roundResult
                .stream()
                .filter(car -> car.isWinner(winnerPosition))
                .collect(Collectors.toList());
    }

    private int findWinnerPosition() {
        int maxPosition = 0;
        for (Car car : roundResult) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }
}
