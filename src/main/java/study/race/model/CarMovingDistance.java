package study.race.model;

public class CarMovingDistance {

    private final int STARTING_POINT = 0;
    private final int MOVE = 1;
    private final int FORWARD_CONDITION_THRESHOLD = 4;

    public int initMovingDistance() {
        return STARTING_POINT;
    }

    public int updateMovingDistance(int currentDistance, int movingDistance) {
        if (checkForwardCondition(movingDistance)) {
            return currentDistance + MOVE;
        }
        return currentDistance;
    }

    private boolean checkForwardCondition(int movingDistance) {
        return movingDistance >= FORWARD_CONDITION_THRESHOLD;
    }
}
