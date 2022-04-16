package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.*;

public class RacingService {

    public static final String REGEX = ",";

    public void StartRacingGame() {
        String[] carNames = InputView.inputRacingCarNames().split(REGEX);
        int attemptsCount = InputView.inputAttemptsCount();

        RacingCars racingCars = generateCars(carNames);
        RacingGameManagement racingGameManagement = initRacingGameManagement(racingCars);
        RacingGame racingGame = new RacingGame(racingCars, attemptsCount, racingGameManagement);

        racingGame.StartRacing();
        ResultView.print(racingGame, racingCars, racingGameManagement);
    }

    private static RacingCars generateCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(carName -> cars.add(generateCar(carName)));

        return new RacingCars(cars);
    }

    private static Car generateCar(String carNames) {
        return new Car(carNames);
    }

    private static RacingGameManagement initRacingGameManagement(RacingCars racingCars) {
        Map<Car, CarDrivingTypes> racingGameManagement = new HashMap<>();
        racingCars.stream()
                .forEach(car -> racingGameManagement.put(car, new CarDrivingTypes(new ArrayList<>())));

        return new RacingGameManagement(racingGameManagement);
    }
}
