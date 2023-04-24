package model;

import java.util.Set;

public class SelectedCarsMoveStrategy implements MoveStrategy {
    private final Set<String> carsToMove;

    public SelectedCarsMoveStrategy(Set<String> carsToMove) {
        this.carsToMove = carsToMove;
    }
    @Override
    public int nextPosition(Car car) {
        if (carsToMove.contains(car.getName())) {
            return car.getPosition() + 1;
        }
        return car.getPosition();
    }
}
