package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {

  public void game() {

    InputView inputView = new InputView();

    int carCount = inputView.inputCarCount();
    List<Car> cars = generateCars(carCount);

    int moveCount = inputView.inputMoveCount();

    startRacing(cars, moveCount);
  }

  void startRacing(List<Car> cars, int moveCount) {

    ResultView resultView = new ResultView();
    IntStream.range(0, moveCount).forEach(moveIndex -> {
      moveCars(cars);
      resultView.printMoveResult(cars);
    });
  }

  List<Car> generateCars(int carCount) {

    return IntStream.range(0, carCount)
        .mapToObj(index -> new Car())
        .collect(Collectors.toList());
  }

  void moveCars(List<Car> cars) {
    cars.forEach(Car::move);
  }
}
