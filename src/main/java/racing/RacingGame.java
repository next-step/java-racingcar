package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {

  private static final int MOVE_RANGE = 10;
  private static final int MIN_NUMBER = 4;

  private InputView inputView;
  private RandomGenerator randomGenerator;

  public RacingGame(InputView inputView) {
    this.inputView = inputView;
    this.randomGenerator = new RandomGenerator(MOVE_RANGE);
  }

  public RacingGame(InputView inputView, RandomGenerator randomGenerator) {
    this.inputView = inputView;
    this.randomGenerator = randomGenerator;
  }

  public List<Car> game() {

    String inputCarNames = inputView.inputCarNames();
    List<Car> cars = generateCars(inputCarNames);

    int moveCount = inputView.inputMoveCount();
    startRacing(cars, moveCount);

    return winner(cars);
  }

  List<Car> winner(List<Car> cars) {

    ResultView resultView = new ResultView();
    List<Car> winnerCars = new ArrayList<>();
    for (Car car : cars) {

      if (winnerCars.isEmpty()) {
        winnerCars.add(car);
        continue;
      }

      if (winnerCars.get(0).getPosition() > car.getPosition()) {
        continue;
      }

      if (winnerCars.get(0).getPosition() < car.getPosition()) {
        winnerCars = new ArrayList<>();
      }

      winnerCars.add(car);
    }

    resultView.printWinner(winnerCars);
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
