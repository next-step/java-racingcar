package racingcar;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {

  public static void main(String[] args) {
    InputView inputView = new InputView();

    List<Car> cars = inputView.prepare();

    int rounds = inputView.getRounds();

    for(int round = 1; round <= rounds; round++) {

      printCurrentRound(round);

      startGame(cars);

      addLineBreak();

    }

  }

  private static void startGame(List<Car> cars) {
    cars.forEach(car -> {
      car.move();
      car.showCurrentPosition();
    });
  }

  private static void printCurrentRound(int round) {
    System.out.println(round + "번째 라운드");
  }

  private static void addLineBreak() {
    System.out.println();
    System.out.println();
  }
}
