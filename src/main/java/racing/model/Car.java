package racing.model;

public class Car {
    private int score;
    private CarMovementStrategy carMovementStrategy;

    public Car(CarMovementStrategy carMovementStrategy) {
        this(0, carMovementStrategy);
    }

    private Car(int position, CarMovementStrategy carMovementStrategy) {
        this.score = position;
        this.carMovementStrategy = carMovementStrategy;
    }

    public void move() {
        if (carMovementStrategy.movable()) {
            score++;
        }
    }

    public int getScore() {
        return this.score;
    }
}
