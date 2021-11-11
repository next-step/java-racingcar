package racinggame.vo;

import racinggame.vo.CarState;

import java.util.Collections;
import java.util.List;

public class MoveResult {
    private final List<CarState> moveResults;

    public MoveResult(List<CarState> moveResults) {
        this.moveResults = moveResults;
    }

    public List<CarState> getResults() {
        return Collections.unmodifiableList(moveResults);
    }
}
