package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.view.ResultView;

public class RacingGame {

  private static final int MOVE_RANGE = 10;
  private static final int MIN_NUMBER = 4;

  private RandomGenerator randomGenerator;

  public RacingGame() {
    this.randomGenerator = new RandomGenerator(MOVE_RANGE);
  }

  public RacingGame(RandomGenerator randomGenerator) {
    this.randomGenerator = randomGenerator;
  }

  public WinnerCars startGame(String carNames, int moveCount) {

    List<Car> cars = generateCars(carNames);
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
