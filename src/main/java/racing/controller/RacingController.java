package racing.controller;

import java.util.List;
import racing.domain.dto.RacingInput;
import racing.domain.dto.RacingOutput;
import racing.service.RacingService;
import racing.domain.strategy.NumberCompareMoveStrategy;
import racing.domain.strategy.RandomNumberGenerator;
import racing.view.RacingInputView;
import racing.view.RacingOutputView;

public class RacingController {

  public void startGame() {
    RacingInputView racingInputView = new RacingInputView();
    RacingInput racingInput = racingInputView.printAndGetRacingInput();

    RacingService racingService = new RacingService(
        new NumberCompareMoveStrategy(new RandomNumberGenerator()));
    List<RacingOutput> racingOutputs = racingService.race(racingInput);

    RacingOutputView racingOutputView = new RacingOutputView(racingOutputs);
    racingOutputView.printRacingOutput();
  }
}
