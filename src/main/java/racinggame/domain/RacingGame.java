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
        for (int i = 0; i < cars.size(); i++) {
            move(movingStrategy, i);
        }
    }

    private void move(MovingStrategy movingStrategy, int index) {
        if(movingStrategy.movable()) {
            cars.move(index);
        }
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
