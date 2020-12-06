package racinggame.domain;

import racinggame.domain.car.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<Integer> positions;

    public GameResult(final List<RacingCar> racingCars) {
        this.positions = new ArrayList<>();
        racingCars.forEach(car -> positions.add(car.getPosition()));
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
