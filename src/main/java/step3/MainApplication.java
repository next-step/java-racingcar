package step3;

public class MainApplication {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    int numCars = inputView.getNumCars();
    int numRounds = inputView.getNumRounds();

    RaceEvaluator raceEvaluator = new RaceEvaluator();

    Racer racer = new Racer(numCars, numRounds, raceEvaluator);
    Result result = racer.race();

    ResultView resultView = new ResultView();
    resultView.showResult(result);
  }
}
