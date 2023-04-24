package racing;

import java.util.List;
import racing.race.Car;
import racing.race.Cars;
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
    List<Car> winner = cars.race(tryNumber);

    OutputView.winner(winner);
  }

}
