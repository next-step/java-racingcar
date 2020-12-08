package step3;

import step3.model.MovingStrategy;

public class Car {
    private Distance distance;

    public Car() {
        this.distance = new Distance();
    }

    public Distance getDistance() {
        return distance;
    }

    public void accelerate(MovingStrategy movingStrategy) {
        if (movingStrategy == null) {
            throw new IllegalArgumentException("moving 전략이 필요합니다");
        }
        distance.addMileage(movingStrategy.move());
    }
}
