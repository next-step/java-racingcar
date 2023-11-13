package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private static final List<List<Integer>> resultBoard = new ArrayList<>();

    public List<List<Integer>> showResult() {
        return resultBoard;
    }

    public void saveRoundResult(List<Integer> roundResult) {
        resultBoard.add(roundResult);
    }
}
