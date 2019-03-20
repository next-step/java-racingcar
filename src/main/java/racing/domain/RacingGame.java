package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.view.ConsoleResultView;

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

  public WinnerCars winner(List<Car> cars) {

    WinnerCars winnerCars = new WinnerCars();
    for (Car car : cars) {
      winnerCars.add(car);
    }

    return winnerCars;
  }

  public void startRacing(List<Car> cars, int moveCount) {

    for (int moveIndex = 0; moveIndex < moveCount; moveIndex++) {
      moveCars(cars);
    }
  }

  public List<Car> generateCars(String carNames) {

    String[] carNameArray = carNames.split(",");
    return Arrays.stream(carNameArray)
        .map(carName -> new Car(randomGenerator, carName))
        .collect(Collectors.toList());
  }

  public void moveCars(List<Car> cars) {
    cars.forEach(car -> car.move(MIN_NUMBER));
  }
}
