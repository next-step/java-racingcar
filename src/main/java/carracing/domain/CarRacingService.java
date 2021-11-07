package carracing.domain;

import carracing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacingService {

  private ResultView resultView;
  private List<Car> carList;
  private Random random = new Random();

  private static final int STEP_INIT_COUNT = 1;
  private static final int STEP_FORWARD_STANDARD = 4;

  public CarRacingService(ResultView resultView) {
    this.resultView = resultView;
  }

  public void doRacing(int numberOfCar, int tryCount) {
    validInputValue(numberOfCar, tryCount);
    initRacing(numberOfCar, tryCount);
    play(resultView, tryCount);
  }

  private void initRacing(int numberOfCar, int tryCount) {
    carList = new ArrayList<>(numberOfCar);
    for (int i = 0; i < numberOfCar; i++) {
      carList.add(new Car(STEP_INIT_COUNT, tryCount));
    }
  }

  private void validInputValue(int numberOfCar, int tryCount) {
    if (numberOfCar < 0 || tryCount < 0) {
      throw new IllegalArgumentException();
    }
  }

  private void play(ResultView result, int tryCount) {
    for (int i = 0; i < tryCount; i++) {
      tryMove();
      result.printStatus(carList);
    }
  }

  private void tryMove() {
    for (Car car : carList) {
      if (isForward(car)) {
        car.plusNowStep();
        car.minusMoveCount();
      }
    }
  }

  public static boolean isForward(Car car) {
    return car.getMoveCount() > 0 && RandomUtils.greaterThanOrEquals(STEP_FORWARD_STANDARD);
  }

}
