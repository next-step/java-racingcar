package racingcar;

public class Main {

  public static void main(String[] args) throws Exception {
    InputView inputView = new InputView();
    RacingRule racingRule = inputView.requireRacingRule();
    Racing racing = new Racing(racingRule, new RandomNumMovingStrategy());
    ResultView resultView = new ResultView(racing);

    while (racing.canTry()) {
      racing.tryMoveCars();
      resultView.print();
    }
  }
}
