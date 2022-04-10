package racingcar;

public class Car {
    private static final String MOVE_EXPRESSION = "-";
    private int moveCount;

    public void addMoveCount(int generateCondition, int moveCondition) {
        if (generateCondition >= moveCondition) {
            moveCount++;
        }
    }

    public String moveCountExpression() {
        String expression = "";
        for (int i = 0; i < moveCount; i++) {
            expression += MOVE_EXPRESSION;
        }
        return expression;
    }
}
