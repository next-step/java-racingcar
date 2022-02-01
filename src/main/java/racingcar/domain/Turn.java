package racingcar.domain;

public class Turn {

    private static final int MINIMUM_TURNS = 1;
    private static final String EXCEPTION_MESSAGE = "[ERROR] 최소 턴 수는 하나 이상이어야 합니다.";

    private int turns;

    public Turn(int turns) {
        validateTurn(turns);
        this.turns = turns;
    }

    public boolean isTurnEnd() {
        return turns < 0;
    }

    private void validateTurn(int turn) {
        if (turn < MINIMUM_TURNS) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public void runGame() {
        turns--;
    }
}
