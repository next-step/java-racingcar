package racing;

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

    int carCount = inputView.inputCarCount();
    List<Car> cars = generateCars(carCount);

    int moveCount = inputView.inputMoveCount();
    startRacing(cars, moveCount);

    return cars;
  }

  void startRacing(List<Car> cars, int moveCount) {

    ResultView resultView = new ResultView();
    for (int moveIndex = 0; moveIndex < moveCount; moveIndex++) {
      moveCars(cars);
      resultView.printMoveResult(cars);
    }
  }

  List<Car> generateCars(int carCount) {

    return IntStream.range(0, carCount)
        .mapToObj(index -> new Car(randomGenerator))
        .collect(Collectors.toList());
  }

  void moveCars(List<Car> cars) {
    cars.forEach(car -> car.move(MIN_NUMBER));
  }


}
