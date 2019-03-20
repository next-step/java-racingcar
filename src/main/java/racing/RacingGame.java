package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.view.InputView;
import racing.view.ResultView;

class RacingGame {

  private static final int MOVE_RANGE = 10;
  private static final int MIN_NUMBER = 4;

  private InputView inputView;
  private RandomGenerator randomGenerator;

  RacingGame(InputView inputView) {
    this.inputView = inputView;
    this.randomGenerator = new RandomGenerator(MOVE_RANGE);
  }

  RacingGame(InputView inputView, RandomGenerator randomGenerator) {
    this.inputView = inputView;
    this.randomGenerator = randomGenerator;
  }

  WinnerCars game() {

    String inputCarNames = inputView.inputCarNames();
    List<Car> cars = generateCars(inputCarNames);

    int moveCount = inputView.inputMoveCount();
    startRacing(cars, moveCount);

    return winner(cars);
  }

  WinnerCars winner(List<Car> cars) {

    ResultView resultView = new ResultView();
    WinnerCars winnerCars = new WinnerCars();
    for (Car car : cars) {
      winnerCars.add(car);
    }

    resultView.printWinner(winnerCars.getWinnerNames());
    return winnerCars;
  }

  void startRacing(List<Car> cars, int moveCount) {

    ResultView resultView = new ResultView();
    for (int moveIndex = 0; moveIndex < moveCount; moveIndex++) {
      moveCars(cars);
      resultView.printMoveResult(cars);
    }
  }

  List<Car> generateCars(String carNames) {

    String[] carNameArray = carNames.split(",");
    return Arrays.stream(carNameArray)
        .map(carName -> new Car(randomGenerator, carName))
        .collect(Collectors.toList());
  }

  void moveCars(List<Car> cars) {
    cars.forEach(car -> car.move(MIN_NUMBER));
  }
}
