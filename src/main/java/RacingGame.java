import model.Car;
import model.GameResult;
import service.GameStrategy;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private final List<Car> cars = new ArrayList();

    private final GameStrategy strategy;

    public RacingGame(GameStrategy strategy, String[] carNames) {
        this.strategy = strategy;
        for (int i = 0; i < carNames.length; i++) {
            this.cars.add(Car.carWithName(carNames[i]));
        }
    }

    public GameResult play() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            moveCarByStrategy(car);
        }
        return new GameResult(cars);
    }

    void moveCarByStrategy(Car car) {
        if (!this.strategy.isCarMove()) {
            return;
        }
        car.move();
    }

}
