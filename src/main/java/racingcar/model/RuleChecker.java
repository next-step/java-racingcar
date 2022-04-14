package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public final class RuleChecker {

    private final MovementRule movementRule;

    public RuleChecker() {
        this(new NextStepRule());
    }

    public RuleChecker(MovementRule movementRule) {
        this.movementRule = movementRule;
    }

    private boolean canMove(int number) {
        return movementRule.meetsRule(number);
    }

    public List<Boolean> checkRule(List<Integer> movableList) {
        return movableList.stream()
                .map(this::canMove)
                .collect(Collectors.toList());
    }
}
