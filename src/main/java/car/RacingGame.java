package car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final Integer START_DISTANCE = 0;

    public static void main(String[] args) {
        racingGameRun();
    }

    public static void racingGameRun() {
        List<Car> cars = createCars(InputView.inputNumberOfCars());
        gameInProgress(InputView.inputNumberOfGames(), cars);
    }

    public static List<Car> createCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(START_DISTANCE));
        }
        return cars;
    }

    public static void gameInProgress(Integer numberOfGames, List<Car> cars) {
        for (int i = 0; i < numberOfGames; i++) {
            gameByCar(cars);
            ResultView.outputGameResult(cars);
            System.out.println();
        }
    }

    private static void gameByCar(List<Car> cars) {
        for (Car car : cars) {
            car.game(RandomNumberGenerator.makeRandomNumber());
        }
    }
}
