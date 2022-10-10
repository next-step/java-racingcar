package racing;

public class Car {
    private final String name;
    private int moves;

    public Car(String name) {
        this(name, 0);
    }

    // only for test
    public Car(String name, int moves) {
        this.name = name;
        this.moves = moves;
    }

    public void tryMove(CarMovingStrategy strategy) {
        if (strategy.shouldMove()) {
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
