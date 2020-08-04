package strategy;

public class AboveNumberMove implements MovableStrategy {

    private int movableNumber;

    public AboveNumberMove(int movableNumber) {
        this.movableNumber = movableNumber;
    }

    @Override
    public boolean move(int number) {
        return number >= movableNumber;
    }
}
