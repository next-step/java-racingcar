package racingCar;

import racingCar.view.OutputView;
import racingCar.domain.Racing;
import racingCar.view.InputView;

public class RacingCarMain {

  public static void main(String[] args) {
      int carNum = InputView.inputCarNums();
      int laps = InputView.inputLaps();

      Racing racing = new Racing(carNum);

      System.out.println("실행 결과");
      for(int i = 0; i < laps; i++) {
          racing.race();
          OutputView.printCars(racing.getRacingCars());
      }
  }

}
