package carracing;

public class Car {

    private MovementCondition movementCondition;

    private Distance distance;

    public Car() {
        this.distance = new Distance();
    }

    public void move() {
        if (movementCondition.isMovable()) {
            this.distance.plus();
        }
    }

    public void assignMovementCondition(int condition) {
        this.movementCondition = new MovementCondition(condition);
    }

    public String distanceToDash() {
        return this.distance.toDash();
    }
}
