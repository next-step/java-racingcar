package step3;

import java.util.ArrayList;

public class CarRacing {

  private final int numOfMove;
  private final ArrayList<Car> carList = new ArrayList<>();

  public CarRacing(final int numOfCars, final int numOfMove) {
    this.numOfMove = numOfMove;
    for (int i = 0; i < numOfCars; i++) {
      carList.add(new Car(new RandomMoveStrategy()));
    }
  }

  public void startRacing() {
    ResultView.printResultTitle();
    for (int i = 0; i < numOfMove; i++) {
      moveAllCars();
      if (i != 0) {
        ResultView.printResultDivider();
      }
      ResultView.printResult(carList);
    }
  }

  private void moveAllCars() {
    carList.forEach(Car::move);
  }
}
