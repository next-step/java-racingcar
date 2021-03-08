package RacingCar;

public class Racing {
    MovementCondition movementCondition;
    int distance;

    public Racing(MovementCondition movementCondition) {
        this.movementCondition = movementCondition;
    }

    int numberOfRacing = 0;

    public void setNumberOfRacing(int numberOfRacing) {
        this.numberOfRacing = numberOfRacing;
    }

    int singleRacing() {
        if (movementCondition.isMovoable()) {
            distance++;
        }
        return distance;
    }

    public int racing() {
        for (int i = 0; i < numberOfRacing; i++) {
            singleRacing();
        }
        return distance;
    }
}
