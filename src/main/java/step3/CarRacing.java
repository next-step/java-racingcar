package step3;

import java.util.ArrayList;

public class CarRacing {

  private final int MOVE_THRESHOLD = 4;

  private final int numOfMove;
  private final ArrayList<Car> carList = new ArrayList<>();

  public CarRacing(final int numOfCars, final int numOfMove) {
    this.numOfMove = numOfMove;
    for (int i = 0; i < numOfCars; i++) {
      carList.add(new Car());
    }
  }

  public void startRacing() {
    ResultView.printResultTitle();
    for (int i = 0; i < numOfMove; i++) {
      allCarsMoveOrStopOnce();
      if (i != 0) {
        System.out.println();
      }
      ResultView.printResult(carList);
    }
  }

  private void allCarsMoveOrStopOnce() {
    for (Car car : carList) {
      if (canMove()) {
        car.move();
      }
    }
  }

  private boolean canMove() {
    if (RandomValueGenerator.getRandomNumber() >= MOVE_THRESHOLD) {
      return true;
    }
    return false;
  }
}
