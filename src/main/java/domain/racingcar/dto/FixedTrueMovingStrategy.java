package domain.racingcar.dto;

public class FixedTrueMovingStrategy implements MovingStrategy {

    @Override
    public boolean checkIfMoveOrNot() {
        return true;
    }
}
