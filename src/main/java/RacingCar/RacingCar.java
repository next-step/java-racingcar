package RacingCar;

public class RacingCar {
    MovementCondition movementCondition;
    int distance;
    public RacingCar(MovementCondition movementCondition) {
        this.movementCondition = movementCondition;
    }

    public int racing() {
        if (movementCondition.isMovoable()) {
            distance++;
        }
        return distance;
    }
}
