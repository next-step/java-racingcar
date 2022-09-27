package racing.strategy;

import racing.model.CarPosition;

public interface CarMoveStrategy {
    public void move(CarPosition position);

    boolean canMove(int randomNum);
}
