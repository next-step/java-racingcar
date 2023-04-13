package study.race;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private List<String> moveHistory;
    private StringBuilder moved;

    public Car() {
        moved = new StringBuilder();
        moveHistory = new ArrayList<>();
    }

    public void move(int randomNum) {
        if (isMoveCondition(randomNum)) {
            moved.append("-");
        }
        moveHistory.add(getScore());
    }

    public boolean isMoveCondition(int randomNum) {
        return randomNum >= 4;
    }

    public List<String> getMoveHistory() {
        return moveHistory;
    }

    public String getScore() {
        return moved.toString();
    }

}
