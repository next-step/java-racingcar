package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
    private static final List<List<Integer>> resultBoard = new ArrayList<>();
    private final Winners winnerList = new Winners();

    public List<List<Integer>> resultBoard() {
        return Collections.unmodifiableList(resultBoard);
    }

    public void saveRoundResult(List<Integer> roundResult) {
        resultBoard.add(roundResult);
    }

    public void saveWinners(Cars cars) {
        winnerList.findWinners(cars);
    }

    public Winners winnerList() {
        return winnerList;
    }
}
