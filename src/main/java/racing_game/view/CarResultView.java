package racing_game.view;

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
    int trialCount = result.getTrialCount().toInt();

    StringBuilder sb = new StringBuilder("실행 결과\n");
    for (int time = 1; time <= trialCount; time++) {
      drawCarsInOneTime(cars, time, sb);
      sb.append("\n");
    }

    return sb.toString();
  }

  private void drawCarsInOneTime(Cars cars, int time, StringBuilder sb) {
    for (Car car : cars) {
      int distance = car.getDistance(time);
      sb.append("_".repeat(distance)).append("\n");
    }
  }
}
