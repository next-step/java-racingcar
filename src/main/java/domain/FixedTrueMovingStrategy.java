package domain;

public class FixedTrueMovingStrategy implements MovingStrategy {

    @Override
    public boolean checkIfMoveOrNot() {
        return true;
    }
}
