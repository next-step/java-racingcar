package car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final Integer START_DISTANCE = 0;

    public static void main(String[] args) {
        racingGameRun();
    }

    public static void racingGameRun() {
        List<Car> carList = createCarList(InputView.inputNumberOfCars());
        gameInProgress(InputView.inputNumberOfGames(), carList);
    }

    public static List<Car> createCarList(int numberOfCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car(START_DISTANCE));
        }
        return carList;
    }

    public static void gameInProgress(Integer numberOfGames, List<Car> carList) {
        for (int i = 0; i < numberOfGames; i++) {
            gameByCar(carList);
            ResultView.outputGameResult(carList);
            System.out.println();
        }
    }

    private static void gameByCar(List<Car> carList) {
        for (Car car : carList) {
            car.game(RandomNumberGenerator.makeRandomNumber());
        }
    }
}
