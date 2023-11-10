package study.race;

public class CarLocationManager {

    private final int STARTING_PORING = 1;
    private final int FORWARD_CONDITION_THRESHOLD = 4;
    public int initMovingDistance() {
        return STARTING_PORING;
    }

    public int updateLocation(int currentDistance, int movingDistance) {
        if (checkForwardCondition(movingDistance)) {
            return currentDistance + movingDistance;
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
