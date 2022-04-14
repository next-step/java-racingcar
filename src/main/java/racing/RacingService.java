package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    public void StartRacingGame() {
        int carCount = InputView.inputCarCount();
        int attemptsCount = InputView.inputAttemptsCount();
        List<Car> cars = generateCars(carCount);
        RacingGameManagement racingGameManagement = initRacingGameManagement(cars);
        Racing racing = new Racing(cars, attemptsCount, racingGameManagement);

        racing.StartRacing();
        ResultView.draw(racing, cars, racingGameManagement);
    }

    private static List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(generateCar());
        }
        return cars;
    }

    private static Car generateCar() {
        return new Car();
    }

    private static RacingGameManagement initRacingGameManagement(List<Car> cars) {
        RacingGameManagement carDrivingStatus = new RacingGameManagement();

        for (Car car : cars) {
            carDrivingStatus.addCar(car.getId());
        }
        return carDrivingStatus;
    }
}
