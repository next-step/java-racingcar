package game;

public class RandomlyMoveCar extends Car {

    @Override
    protected MoveRule getMoveRule() {
        return new RandomlyMoveRule(new RandomNumberProviderImpl(10));
    }
}
