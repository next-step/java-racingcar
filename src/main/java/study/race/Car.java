package study.race;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private List<Integer> moveHistory;
    private int moved = 0;

    public Car() {
        moveHistory = new ArrayList<>();
    }

    public void move(int conditionNum) {
        if (isMoveCondition(conditionNum)) {
            moved++;
        }
        moveHistory.add(getScore());
    }

    public boolean isMoveCondition(int conditionNum) {
        return conditionNum >= 4;
    }

    public List<Integer> getMoveHistory() {
        return moveHistory;
    }

    public int getScore() {
        return moved;
    }

}
