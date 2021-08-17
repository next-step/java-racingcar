package step45.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

  private int numOfMove;
  private final Cars cars;
  private final MoveStrategy moveStrategy;

  public CarRacing(final String[] carNames, final int numOfMove, MoveStrategy moveStrategy) {
    this.numOfMove = numOfMove;
    this.cars = initCars(carNames);
    this.moveStrategy = moveStrategy;
  }

  private Cars initCars(String[] carNames) {
    final Cars cars;
    List<Car> carList = new ArrayList<>();
    for (String carName : carNames) {
      carList.add(new Car(carName));
    }
    cars = new Cars(carList);
    return cars;
  }

  public boolean isFinish() {
    return this.numOfMove > 0;
  }

  public void moveCars() {
    cars.moveCars(moveStrategy);
    this.numOfMove--;
  }

  public List<Car> getWinners() {
    return cars.getWinners();
  }

  public List<Car> getCars() {
    return cars.getCars();
  }
}
