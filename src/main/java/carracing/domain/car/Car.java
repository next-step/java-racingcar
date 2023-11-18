package carracing.domain.car;

import carracing.domain.game.MovingStrategy;
import carracing.util.controlstatement.Boolean;
import carracing.util.controlstatement.Equal;

public class Car {
    private static final int MOVING_DISTANCE = 1;

    private int movingDistance;
    private final CarName carName;

    public Car(CarName name) {
        this(0, name);
    }

    public Car(int movingDistance, CarName carName) {
        this.movingDistance = movingDistance;
        this.carName = carName;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isPossible()) {
            moveDistance();
        }
    }

    private void moveDistance() {
        this.movingDistance += MOVING_DISTANCE;
    }

    public int movingDistance() {
        return this.movingDistance;
    }

    public String name() {
        return this.carName.name();
    }

    public boolean sameDistance(int movingDistance) {
        Boolean same = new Equal(this.movingDistance, movingDistance);

        return same.booleanValue();
    }

    public int maxDistance(int inputDistance) {
        return Math.max(this.movingDistance, inputDistance);
    }
}
