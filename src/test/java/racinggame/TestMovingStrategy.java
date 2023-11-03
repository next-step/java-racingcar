package racinggame;

public class TestMovingStrategy implements MovingStrategy {

    private final int number;

    public TestMovingStrategy(int number) {
        this.number = number;
    }

    @Override
    public int nextInt() {
        return this.number;
    }

}
