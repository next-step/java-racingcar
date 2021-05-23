package racing.domain;

public class Car {
    private static final int VALIDATED_NAME_LENGTH = 5;
    private String name;
    private MovedLog movedLog;
    private MoveConditionStrategy moveConditionStrategy;

    public Car(String name, MoveConditionStrategy moveConditionStrategy) {
        validateLength(name);
        this.name = name;
        this.moveConditionStrategy = moveConditionStrategy;
        this.movedLog = new MovedLog();
    }

    private void validateLength(String name) {
        if (name.length() > VALIDATED_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        }
    }

    public boolean isMove() {
        if (moveConditionStrategy.isMovable()) {
            movedLog.addMoveCount();
            movedLog.addMovedLog();
            return true;
        }
        movedLog.addMovedLog();
        return false;
    }

    public boolean isWinner(int winnerCount) {
        return movedLog.getMoveCount() == winnerCount;
    }

    public String getName() {
        return name;
    }

    public MovedLog getMovedLog() {
        return movedLog;
    }

    public int getMoveCount() {
        return movedLog.getMoveCount();
    }
}
