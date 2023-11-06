package racinggame.domain;

import java.util.List;
import racinggame.domain.strategy.MovingStrategy;

public class RacingGame {

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public int carsCount() {
        return this.cars.size();
    }

    public void play(MovingStrategy movingStrategy) {
        cars.move(movingStrategy);
    }

    public Cars cars() {
        return cars;
    }

    public List<Distance> report() {
        return cars.movingDistances();
    }

    public Cars winners() {
        return cars.mostMoved();
    }
}
