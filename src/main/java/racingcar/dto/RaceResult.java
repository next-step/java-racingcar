package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    private List<MoveResult> moveLogs;

    public RaceResult() {
        this.moveLogs = new ArrayList<>();
    }

    public RaceResult(List<MoveResult> moveLogs) {
        this.moveLogs = moveLogs;
    }

    public List<MoveResult> getMoveLogs() {
        return moveLogs;
    }

    public void addMoveResult(MoveResult moveResult) {
        this.moveLogs.add(moveResult);
    }

}
