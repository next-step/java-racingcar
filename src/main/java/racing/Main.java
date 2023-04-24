package racing;

import java.util.List;
import racing.race.Car;
import racing.race.Cars;
import racing.race.Winners;
import racing.view.InputView;
import racing.view.OutputView;

public class Main {

  public static void main(String[] args) {
    OutputView.getCarsName();
    String carsName = InputView.getStringValue();
    Cars cars = new Cars(carsName);

    OutputView.getTryNumger();
    int tryNumber = InputView.getIntValue();

    OutputView.result();
    List<Car> winners = cars.race(tryNumber);

    OutputView.winner(new Winners().getWinnersName(winners));
  }

}
