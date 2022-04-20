package domain;

import java.util.Objects;
import model.CarName;
import model.CarPosition;

public class CarInfo implements Comparable<CarInfo> {

  private final CarName carName;
  private final CarPosition carPosition;

  CarInfo(CarName carName, CarPosition carPosition) {
    Objects.requireNonNull(carName);
    Objects.requireNonNull(carPosition);
    this.carName = carName;
    this.carPosition = carPosition;
  }

  public String getNameOfCar() {
    return carName.toString();
  }

  public int getPositionOfCar() {
    return carPosition.toInt();
  }

  @Override
  public int compareTo(CarInfo other) {
    return carPosition.compareTo(other.carPosition);
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarInfo carInfo = (CarInfo) o;
    return carName.equals(carInfo.carName) && carPosition.equals(carInfo.carPosition);
  }
}
