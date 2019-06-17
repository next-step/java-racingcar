package racingcar;

import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {

  private InputView inputView;

  public RacingGame() {
    this.inputView = new InputView();;
  }

  public void startRacing() {
    // client에게 최초 질문
    inputView.askQuestions();

    String[] names = inputView.getNames();
    int rounds = inputView.getRounds();

    // name을 가진 Car 생성
    List<Car> cars = CarFactory.generate(names);
    printRacingStatus(rounds, cars);
  }

  static void printRacingStatus(int rounds, List<Car> cars) {
    for(int round = 1; round <= rounds; round++) {
      ResultView.printCurrentRound(round);
      drive(cars);
      ResultView.addLineBreak();
    }

    ResultView.printWinner(cars);
  }

  static void drive(List<Car> cars) {
    cars.forEach(car -> {
      car.move();
      ResultView.printCurrentPositionOf(car);
    });
  }
}
