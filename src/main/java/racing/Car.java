package racing;

public class Car {
    private final CarMovingStrategy carMovingStrategy;
    private final String name;
    private int moves = 0;

    public Car(String name) {
        this(name, new RandomCarMovingStrategy());
    }

    public Car(String name, CarMovingStrategy strategy) {
        this.name = name;
        this.carMovingStrategy = strategy;
    }

    public void tryMove() {
        if (carMovingStrategy.shouldMove()) {
            moves++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoves() {
        return moves;
    }
}
