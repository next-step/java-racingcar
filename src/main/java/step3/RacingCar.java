package step3;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCar {
  private static final InputView inputView = new InputView();
  private static final ResultView resultView = new ResultView();

  public void run() {
    int car = inputView.setCarCount();
    if (car == 0) {
      throw new IllegalArgumentException("자동차 수가 0입니다.");
    }
    Set<Car> carSet = IntStream.range(0, car).mapToObj(Car::new).collect(Collectors.toSet());
    resultView.resultPrint(carSet);
  }
}
