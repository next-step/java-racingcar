package racingcar.ui.dto;

import java.util.List;

public class RacingGameResponse {

    private List<Integer> moveCounts;

    public RacingGameResponse(List<Integer> moveCounts) {
        this.moveCounts = moveCounts;
    }

    public List<Integer> getMoveCounts() {
        return moveCounts;
    }
}
