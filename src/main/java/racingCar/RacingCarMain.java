package racingCar;

import racingCar.domain.RacingResult;
import racingCar.view.OutputView;
import racingCar.domain.Racing;
import racingCar.view.InputView;

public class RacingCarMain {

  public static void main(String[] args) {
      String carNames = InputView.inputCarNames();
      int laps = InputView.inputLaps();

      Racing racing = new Racing(carNames);

      System.out.println("실행 결과");
      for(int i = 0; i < laps; i++) {
          racing.race();
          OutputView.printCars(racing.getRacingCars());
      }

      RacingResult result = new RacingResult(racing.getRacingCars());
      result.getWinners();
      System.out.println(result.toString());
  }

}
