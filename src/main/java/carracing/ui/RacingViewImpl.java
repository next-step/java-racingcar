package carracing.ui;

import carracing.domain.dto.RacingResult;
import carracing.domain.entity.Participant;
import carracing.domain.entity.Round;

public class RacingViewImpl implements RacingView{

  private InputView inputView;
  private ResultView resultView;

  public RacingViewImpl(InputView inputView, ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  public Participant getNumberOfCar() {
    return inputView.inputNumberOfCar();
  }

  public Round getRound() {
    return inputView.inputTryCount();
  }

  public void printResult(RacingResult result) {
    resultView.printResult(result);
  }

}
