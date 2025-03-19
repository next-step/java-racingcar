package step3;

public class MainApplication {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    int carCount = inputView.getCarCount();
    int roundCount = inputView.getRoundCount();

    RaceEvaluator raceEvaluator = new RaceEvaluator();

    Racer racer = new Racer(carCount, roundCount, raceEvaluator);
    Result result = racer.race();

    ResultView resultView = new ResultView();
    resultView.showResult(result);
  }
}
