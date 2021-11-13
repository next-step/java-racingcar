package racinggame;

import racinggame.vo.MoveResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    private static final int INDEX_CORRECT_ADJUSTMENT_NUMBER = 1;

    private final List<MoveResult> moveResults;

    public RacingResult(List<MoveResult> moveResults) {
        this.moveResults = moveResults;
    }

    public List<MoveResult> results() {
        return Collections.unmodifiableList(moveResults);
    }

    public Names findWinners() {
        List<Car> winners = moveResults.get(moveResults.size() - INDEX_CORRECT_ADJUSTMENT_NUMBER)
                .findWinner();

        List<String> names = winners.stream()
                .map(Car::name)
                .collect(Collectors.toList());

        return Names.createNames(names);
    }
}
