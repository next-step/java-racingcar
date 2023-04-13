package racing.controller;


import java.util.List;
import racing.view.InputView;
import racing.view.ResultView;
import racing.domain.Car;
import racing.domain.RacingGame;

public class RacingCarGameController {

  public static void main(String[] args) {
    int carCount = InputView.scanCarCounts();
    int numberOfMovements = InputView.scanNumberOfMovements();

    RacingGame game = new RacingGame(carCount);

    ResultView.printEmptyLine();
    ResultView.println("실행 결과");
    for(int i = 0; i < numberOfMovements; i++) {
      List<Car> cars = game.play();
      ResultView.printCarPosition(cars);
      ResultView.printEmptyLine();
    }
  }

}
