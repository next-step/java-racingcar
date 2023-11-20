package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
    private static final List<List<Integer>> resultBoard = new ArrayList<>();

    public List<List<Integer>> showResult() {
        return Collections.unmodifiableList(resultBoard);
    }

    public void saveRoundResult(List<Integer> roundResult) {
        resultBoard.add(roundResult);
    }
}
