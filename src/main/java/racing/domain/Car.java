package racing.domain;

public class Car {
    private static final int VALIDATED_NAME_LENGTH = 5;
    private static final int MOVED_DISTANCE = 1;
    private static final int NOT_MOVED_DISTANCE = 0;

    private String name;
    private CarDistanceLog distanceLog;
    private MoveConditionStrategy moveConditionStrategy;

    public Car(String name, MoveConditionStrategy moveConditionStrategy) {
        validateLength(name);
        this.name = name;
        this.moveConditionStrategy = moveConditionStrategy;
        this.distanceLog = new CarDistanceLog();
    }

    public Car(String name, MoveConditionStrategy moveConditionStrategy, int initDistance) {
        this(name, moveConditionStrategy);
        this.distanceLog = new CarDistanceLog(initDistance);
    }

    private void validateLength(String name) {
        if (name.length() > VALIDATED_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        }
    }

    public void move() {
        boolean canMove = moveConditionStrategy.isMovable();
        if (canMove) {
            distanceLog.addMovedLog(MOVED_DISTANCE);
        }
        if (!canMove) {
            distanceLog.addMovedLog(NOT_MOVED_DISTANCE);
        }
    }

    public boolean isWinner(int winnerPosition) {
        return distanceLog.isWinner(winnerPosition);
    }

    public String getName() {
        return name;
    }

    public int getMovedLogByRound(int round) {
        return distanceLog.getDistanceByRound(round);
    }

    public int getFinalDistance() {
        return distanceLog.getFinalDistance();
    }
}
