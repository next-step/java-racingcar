package step3;

import java.util.Map;

public class MainApplication {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    int numCars = inputView.getNumCars();
    int numTry = inputView.getNumTry();

    Racer racer = new Racer(numCars, numTry);
    Map<Integer, int[]> result = racer.race();

    ResultView resultView = new ResultView();
    resultView.showResult(result);
  }
}
