package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class MovementChecker {

    private static final int MOVEMENT_RULE_NUMBER = 4;

    public boolean canMove(int number) {
        return number >= MOVEMENT_RULE_NUMBER;
    }

    public List<Boolean> checkMovableList(List<Integer> movableList) {
        return movableList.stream()
                .map(this::canMove)
                .collect(Collectors.toList());
    }
}
