package domain;

public class FixedFalseMovingStrategy implements MovingStrategy {

    @Override
    public boolean checkIfMoveOrNot() {
        return false;
    }
}
