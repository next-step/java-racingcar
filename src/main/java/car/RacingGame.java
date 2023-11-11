package car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int START_DISTANCE = 0;
    private static final int GREATER_THAN_WINNER = 0;
    private static final InputParser inputParser = new InputParser();
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void startRacingGame() {
        List<Car> cars = createCars(inputParser.parseUserInputByDelimiter(InputView.inputCarNames()));
        playGame(InputView.inputNumberOfGames(), cars);
        ResultView.outputFinalGameResult(findTiedWinnerCarNames(cars, findFinalWinner(cars)));
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
            ResultView.outputEachGameResult(cars);
        }
    }

    private void playGameByCars(List<Car> cars) {
        for (Car car : cars) {
            car.game(randomNumberGenerator.makeRandomNumber());
        }
    }

    public List<String> findTiedWinnerCarNames(List<Car> cars, Car winnerCar) {
        return cars.stream()
                .filter(car -> car.isSameDistance(winnerCar))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public Car findFinalWinner(List<Car> cars) {
        Car winnerCar = cars.get(0); //todo stream을 안 쓰고, 개선의 여지가 있을지 고민.
        for (Car car : cars) {
            winnerCar = changeWinnerCar(winnerCar, car);
        }
        return winnerCar;
    }

    private Car changeWinnerCar(Car winnerCar, Car car) {
        if (car.compareTo(winnerCar) > GREATER_THAN_WINNER) { //todo
            return car;
        }
        return winnerCar;
    }
}
