package domain.racingcar.dto;

public class FixedFalseMovingStrategy implements MovingStrategy {

    @Override
    public boolean checkIfMoveOrNot() {
        return false;
    }
}
