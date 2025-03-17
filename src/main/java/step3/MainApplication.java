package step3;

import java.util.Map;

public class MainApplication {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    int numCars = inputView.askInt("자동차 대수는 몇 대 인가요?");
    int numTry = inputView.askInt("시도할 회수는 몇 회 인가요?");

    Racer racer = new Racer(numCars, numTry);
    Map<Integer, int[]> result = racer.race();

    ResultView resultView = new ResultView();
    resultView.showResult(result);
  }
}
