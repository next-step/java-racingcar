package racinggame;

import racinggame.domain.model.RacingResult;
import racinggame.view.InputView;
import racinggame.view.ResultView;
import racinggame.vo.RacingInfo;

public class CarRacingRunner {

  public static void main(String[] args) {
    RacingInfo racingInfo = InputView.racingInfoForm();
    CarRacing carRacing = new CarRacing(racingInfo);
    RacingResult racingResult = carRacing.startRacing();
    ResultView.printRacingResult(racingResult);
    ResultView.printFinalWinnerCarNames(racingResult);
  }
}
