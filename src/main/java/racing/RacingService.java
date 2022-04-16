package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingService {
    public void StartRacingGame() {
        String[] carNames = InputView.inputRacingCarNames().split(",");
        int attemptsCount = InputView.inputAttemptsCount();

        RacingCars racingCars = generateCars(carNames);
        RacingGameManagement racingGameManagement = initRacingGameManagement(racingCars);
        RacingGame racingGame = new RacingGame(racingCars, attemptsCount, racingGameManagement);

        racingGame.StartRacing();
        ResultView.print(racingGame, racingCars, racingGameManagement);
    }

    private static RacingCars generateCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(generateCar(carName));
        }
        return new RacingCars(cars);
    }

    private static Car generateCar(String carNames) {
        return new Car(carNames);
    }

    private static RacingGameManagement initRacingGameManagement(RacingCars racingCars) {
        Map<Car, CarDrivingTypes> racingGameManagement = new HashMap<>();

        for (Car car : racingCars) {
            racingGameManagement.put(car, new CarDrivingTypes(new ArrayList<CarDrivingType>()));
        }
        return new RacingGameManagement(racingGameManagement);
    }
}
