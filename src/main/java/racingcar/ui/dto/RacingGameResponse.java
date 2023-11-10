package racingcar.ui.dto;

import java.util.HashMap;
import java.util.List;
public class RacingGameResponse {
    private HashMap<Integer, List<Integer>> moveCountsByTurn;

    public RacingGameResponse(HashMap<Integer, List<Integer>> moveCountsByTurn) {
        this.moveCountsByTurn = moveCountsByTurn;
    }

    public HashMap<Integer, List<Integer>> getMoveCountsByTurn() {
        return moveCountsByTurn;
    }
}
