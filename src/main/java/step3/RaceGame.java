package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import step3.data.Car;
import step3.data.Race;
import step3.view.InputView;
import step3.view.ResultView;

public class RaceGame {

  public void start() {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    Race race = new Race();

    // 자동차 댓수 입력
    int carNum = inputView.getCarNum();
    for (int i = 0; i < carNum; i++) {
      race.carList.add(new Car());
    }

    // 경주 횟수 입력
    int raceCount = inputView.getRaceCount();
    race.laps = raceCount;


    for(Car car : race.carList) {
      car.move(new Random().nextInt(10));
      resultView.printPosition(car.position);
    }

  }

}
