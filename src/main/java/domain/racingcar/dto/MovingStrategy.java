package domain.racingcar.dto;

@FunctionalInterface
public interface MovingStrategy {
    boolean checkIfMoveOrNot();
}
