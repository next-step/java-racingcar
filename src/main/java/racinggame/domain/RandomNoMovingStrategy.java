package racinggame.domain;

public class RandomNoMovingStrategy implements MovingStrategy {
    private static final int FORWARD_NUM = 4;

    private final int number;

    public RandomNoMovingStrategy(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean movable() {
        return this.number >= 4;
    }
}
