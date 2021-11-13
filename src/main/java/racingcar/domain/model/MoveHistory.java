package racingcar.domain.model;

import racingcar.domain.exception.HistoryOutOfBoundsException;
import java.util.ArrayList;
import java.util.List;

public class MoveHistory {

    private static final int START_INDEX = 0;
    private static final boolean SUCCESS = true;

    private List<Boolean> moveHistory;

    private MoveHistory(List<Boolean> history) {
        moveHistory = history;
    }

    public static MoveHistory create() {
        return new MoveHistory(new ArrayList<>());
    }

    public static MoveHistory of(List<Boolean> history) {
        return new MoveHistory(history);
    }


    public void addHistory(boolean isMove) {
        moveHistory.add(isMove);
    }

    public long size() {
        return moveHistory.size();
    }

    public long size(boolean bool) {
        return moveHistory.stream()
            .filter(f -> f.equals(bool))
            .count();
    }

    public long getSuccessCount(int toIndex) {
        return this.getMoveHistory(toIndex).size(SUCCESS);
    }

    private MoveHistory getMoveHistory(int toIndex) {
        try {
            return MoveHistory.of(new ArrayList<>(moveHistory.subList(START_INDEX, toIndex)));
        } catch (IndexOutOfBoundsException e) {
            throw new HistoryOutOfBoundsException();
        }
    }
}
