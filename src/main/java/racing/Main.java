package racing;

import racing.race.Cars;
import racing.race.Racing;
import racing.view.InputView;
import racing.view.OutputView;

public class Main {

  public static void main(String[] args) {
    int carNumber = InputView.getValue("자동차 대수는 몇 대 인가요?");
    Cars cars = new Cars();
    cars.ready(carNumber);

    int tryNumber = InputView.getValue("시도할 회수는 몇 회 인가요?");

    OutputView.print("\n실행 결과");

    Racing racing = new Racing();
    racing.race(cars.getGameCar(), tryNumber);
  }

}
