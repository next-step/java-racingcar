package racing.domain;

public class Car {
    private static final int VALIDATED_NAME_LENGTH = 5;
    private static final int MOVED_DISTANCE = 1;
    private static final int NOT_MOVED_DISTANCE = 0;

    private String name;
    private MovedLog movedLog;
    private MoveConditionStrategy moveConditionStrategy;

    public Car(String name, MoveConditionStrategy moveConditionStrategy) {
        validateLength(name);
        this.name = name;
        this.moveConditionStrategy = moveConditionStrategy;
        this.movedLog = new MovedLog();
    }

    public Car(String name, MoveConditionStrategy moveConditionStrategy, int initDistance) {
        this(name, moveConditionStrategy);
        this.movedLog = new MovedLog(initDistance);
    }

    private void validateLength(String name) {
        if (name.length() > VALIDATED_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        }
    }

    public void move() {
        boolean canMove = moveConditionStrategy.isMovable();
        if (canMove) {
            movedLog.addMovedLog(MOVED_DISTANCE);
        }
        if (!canMove) {
            movedLog.addMovedLog(NOT_MOVED_DISTANCE);
        }
    }

    public boolean isWinner(int winnerPosition) {
        return movedLog.isWinner(winnerPosition);
    }

    public String getName() {
        return name;
    }

    public int getMovedLogByRound(int round) {
        return movedLog.getPositionByRound(round);
    }

    public int getLastPosition() {
        return movedLog.getFinalDistance();
    }
}
