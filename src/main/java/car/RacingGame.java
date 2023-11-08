package car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int START_DISTANCE = 0;
    private static final int GREATER_THAN_WINNER = 0;
    private static final InputParser inputParser = new InputParser();
    private static final Integer START_DISTANCE = 0;
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

    //todo 들여쓰기 1로 줄이기 위해, 파라미터가 증가하는데 괜찮은지
    public List<String> findTiedWinnerCarNames(List<Car> cars, Car winnerCar) {
        List<String> winnerCarNames = new ArrayList<>();
        for (Car car : cars) {
            addTiedWinnerCarName(winnerCarNames, car, winnerCar);
        }
        return winnerCarNames;
    }

    private void addTiedWinnerCarName(List<String> winnerCarNames, Car car, Car winnerCar) {
        if (car.isSameDistance(winnerCar)) {
            winnerCarNames.add(car.getCarName());
        }
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
