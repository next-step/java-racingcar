package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    public static void StartGame() {
        InputView inputView = new InputView();
        int carCount = inputView.getCarCount();
        int attemptsCount = inputView.getAttemptsCount();

        List<Car> cars = generateCars(carCount);
        CarDrivingStatus carDrivingStatus = initCarDrivingStatus(cars);
        Racing racing = new Racing(cars, attemptsCount, carDrivingStatus);

        racing.StartRacing();
        ResultView.draw(racing, cars, carDrivingStatus);
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

    private static CarDrivingStatus initCarDrivingStatus(List<Car> cars) {
        CarDrivingStatus carDrivingStatus = new CarDrivingStatus();

        for (Car car : cars) {
            carDrivingStatus.addCar(car.getId());
        }
        return carDrivingStatus;
    }
}
