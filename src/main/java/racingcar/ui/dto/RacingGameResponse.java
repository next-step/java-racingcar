package racingcar.ui.dto;

import java.util.HashMap;
import java.util.List;
public class RacingGameResponse {
    private HashMap<Integer, List<Integer>> moveCountsByTurn = moveCountsByTurn = new HashMap<>();

    public RacingGameResponse() {}

    public void setMoveCountByTurn(int turn, List<Integer> moveCounts) {
        moveCountsByTurn.put(turn, moveCounts);
    }
    public HashMap<Integer, List<Integer>> getMoveCountsByTurn() {
        return moveCountsByTurn;
    }
}
