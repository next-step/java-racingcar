package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    List<Boolean> moveHistory = new ArrayList<>();

    public List<Boolean> getMoveHistory() {
        return moveHistory;
    }

    public boolean getIsMoveByIndex(int index) {
        return moveHistory.get(index);
    }

    public void addMoveHistory(boolean isMove) {
        moveHistory.add(isMove);
    }
}
