package car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final Integer START_DISTANCE = 0;
    private final RandomNumberGenerator randomNumberGenerator;
    private static final InputParser inputParser = new InputParser();

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void startRacingGame() {
        List<Car> cars = createCars(inputParser.parseUserInputByDelimiter(InputView.inputCarNames()));
        playGame(InputView.inputNumberOfGames(), cars);
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(START_DISTANCE, carName));
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
