package car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final Integer START_DISTANCE = 0;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void startRacingGame() {
        List<Car> cars = createCars(InputView.inputNumberOfCars());
        playGame(InputView.inputNumberOfGames(), cars);
    }

    public List<Car> createCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(START_DISTANCE));
        }
        return cars;
    }

    public void playGame(Integer numberOfGames, List<Car> cars) {
        for (int i = 0; i < numberOfGames; i++) {
            playGameByCars(cars);
            ResultView.outputGameResult(cars);
            System.out.println();
        }
    }

    private void playGameByCars(List<Car> cars) {
        for (Car car : cars) {
            car.game(randomNumberGenerator.makeRandomNumber());
        }
    }
}
