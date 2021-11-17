package carracing.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Cars {

  private static final int FIRST_INDEX = 0;

  private final List<Car> carList;

  public Cars() {
    this.carList = new ArrayList<>();
  }

  public Cars(List<Car> carList) {
    this.carList = carList;
  }

  public void register(Car car) {
    carList.add(car);
  }

  public void notifyCarOfStart(BooleanSupplier isMovable) {
    for (Car car : getCarList()) {
      car.move(isMovable);
    }
  }

  public List<Car> getCarList() {
    return carList;
  }

  public Cars getWinner() {
    List<Car> carList = new ArrayList<>(this.carList);
    Collections.sort(carList);
    return findWinner(carList);
  }

  private Cars findWinner(List<Car> carList) {
    Car firstCar = carList.get(FIRST_INDEX);

    return new Cars(getSameStepCars(carList, firstCar));
  }

  private List<Car> getSameStepCars(List<Car> carList, Car firstCar) {
    List<Car> winners = new ArrayList<>();
    int nextIndex = 1;

    while (firstCar.equalStep(carList.get(nextIndex))) {
      winners.add(carList.get(nextIndex));
      nextIndex++;
    }

    return winners;
  }
}
