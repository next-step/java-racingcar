package study.race.model;

public class CarLocationManager {

    private final int STARTING_POINT = 0;
    private final int MOVE = 1;
    private final int FORWARD_CONDITION_THRESHOLD = 4;

    public int initMovingDistance() {
        return STARTING_POINT;
    }

    public int updateLocation(int currentDistance, int movingDistance) {
        if (checkForwardCondition(movingDistance) || currentDistance == STARTING_POINT) {
            return currentDistance + MOVE;
        }
        return currentDistance;
    }

    private boolean checkForwardCondition(int movingDistance) {
        if (movingDistance >= FORWARD_CONDITION_THRESHOLD) {
            return true;
        }
        return false;
    }
}
