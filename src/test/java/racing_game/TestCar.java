package racing_game;

public class TestCar extends Car {

    private final int moveCount;

    public TestCar(String name, int moveCount) {
        super(name);
        this.moveCount = moveCount;
    }

    @Override
    public int getMoveCount() {
        return this.moveCount;
    }

}
