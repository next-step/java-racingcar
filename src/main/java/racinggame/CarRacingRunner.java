package racinggame;

import racinggame.model.RacingResult;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;
import racinggame.vo.RacingInfo;

public class CarRacingRunner {

  public static void main(String[] args) {
    RacingInfo racingInfo = InputView.racingInfoForm();
    CarRacing carRacing = new CarRacing(racingInfo);
    RacingResult racingResult = carRacing.startRacing();
    ResultView.printRacingResult(racingResult);
  }
}
