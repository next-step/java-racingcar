package racingcar;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private static final int RANGE_START_RANDOM_NUMBER = 0;
    private static final int RANGE_END_RANDOM_NUMBER = 9;
    private int moveCount;

    public void addMoveCount(int generateCondition) {
        if (!validateCondition(generateCondition)) {
            throw new IllegalArgumentException("경주 환경에 문제가 생겼습니다. 관리자에게 문의 해 주세요.");
        }

        if (isMove(generateCondition)) {
            moveCount++;
        }
    }

    private boolean validateCondition(int generateCondition) {
        return generateCondition >= RANGE_START_RANDOM_NUMBER
                && generateCondition <= RANGE_END_RANDOM_NUMBER;
    }

    private boolean isMove(int generateCondition) {
        return generateCondition >= MOVE_CONDITION;
    }

    public String moveCountExpression(String moveExpression) {
        String expression = "";
        for (int i = 0; i < moveCount; i++) {
            expression += moveExpression;
        }
        return expression;
    }

}
