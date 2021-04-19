package step3;

import java.util.List;
import java.util.Random;
import step3.data.Car;
import step3.data.Race;
import step3.view.ResultView;

public class RaceGame {
  private ResultView resultView;
  public static Race race;

  public RaceGame() {
    resultView = new ResultView();
    race = new Race();
  }

  public void init(int carNum, int raceCount) {
    // 자동차 댓수 입력
    for (int i = 0; i < carNum; i++) {
      race.getCarList().add(new Car());
    }
    // 경주 횟수 입력
    race.setLaps(raceCount);
}

  public void start() {
    resultView.printHeader();
    for(int i = 0; i < race.getLaps(); i ++) {
      racing(race.getCarList());
      resultView.printLapResult(race.getCarList());
    }
  }

  private void racing(List<Car> carList) {
    for (Car car : carList) {
      car.move(new Random().nextInt(10));
    }
  }

}
