package carracing;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(List<String> names) {
        this.cars = new Cars(names);
    }

    public List<Car> doRacing(MovingStrategy movingStrategy) {
        return cars.move(movingStrategy);
    }

    public List<Car> findWinner() {
        Position biggestPosition = cars.findBiggestPosition();
        return cars.findWinner(biggestPosition);
    }
}
