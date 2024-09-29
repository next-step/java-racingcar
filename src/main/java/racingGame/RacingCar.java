package racingGame;

public class RacingCar {
    private int position;
    private final MovementCondition movementCondition;

    public RacingCar(MovementCondition movementCondition) {
        this.position = 0;
        this.movementCondition = movementCondition;
    }

    public void move() {
        if (movementCondition.canMove()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

}
