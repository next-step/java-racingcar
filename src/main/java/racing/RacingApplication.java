package racing;

import racing.io.InputView;
import racing.model.Car;
import racing.model.RacingGame;

import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {
        List<Car> cars = InputView.createCarsByNames();
        int raceCount = InputView.getRaceCount();
        RacingGame.of(cars, raceCount).run();

    }
}
