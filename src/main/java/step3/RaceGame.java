package step3;

import step3.data.Cars;
import step3.view.InputView;
import step3.view.ResultView;

public class RaceGame {
  private InputView inputView = new InputView();
  private ResultView resultView = new ResultView();
  private Cars cars;

  public void start() {
    cars = new Cars(inputView.getCarNum());
    int raceCount = inputView.getRaceCount();

    resultView.printHeader();
    for(int i = 0; i < raceCount; i ++) {
      cars.race();
      resultView.printLapResult(cars.getCarList());
    }
  }

}
