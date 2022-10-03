package racing;

public class Car {
    private final CarMovingStrategy carMovingStrategy;
    private int moves = 0;

    public Car() {
        this(new RandomCarMovingStrategy());
    }

    public Car(CarMovingStrategy strategy) {
        this.carMovingStrategy = strategy;
    }

    public void tryMove() {
        if (carMovingStrategy.shouldMove()) {
            moves++;
        }
    }

    public int getMoves() {
        return moves;
    }
}
