package racing_game.view;

import racing_game.core.Positive;
import racing_game.domain.Car;
import racing_game.domain.Cars;
import racing_game.domain.Simulator;

public class CarResultView implements ResultView<Simulator> {

  private CarResultView() {}

  public static CarResultView create() {
    return new CarResultView();
  }

  @Override
  public String resolve(Simulator result) {
    Cars cars = result.getCars();
    Positive numberOfTrials = result.getNumberOfTrials();

    StringBuilder sb = new StringBuilder("실행 결과\n");
    for (int targetTime = 1; targetTime <= numberOfTrials.toInteger(); targetTime++) {
      drawCarsInOneTime(cars, targetTime, sb);
      sb.append("\n");
    }

    return sb.toString();
  }

  private void drawCarsInOneTime(Cars cars, int targetTime, StringBuilder sb) {
    for (Car car : cars) {
      int distance = car.getDistance(targetTime);
      sb.append("_".repeat(distance)).append("\n");
    }
  }
}
