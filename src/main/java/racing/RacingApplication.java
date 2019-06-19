package racing;

import racing.io.InputView;
import racing.model.Car;
import racing.model.CarFactory;
import racing.model.RacingGame;

import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {
        List<Car> cars = CarFactory.createByCount(InputView.carCount());
        int raceCount = InputView.raceCount();
        RacingGame.of(cars, raceCount).run();
    }
}
