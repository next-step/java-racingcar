package core.car;

import core.util.Util;

public class CarImpl implements CarInterface {

  Util util;

  public CarImpl(Util util) {
    this.util = util;
  }

  @Override
  public Car createCar(String carName, Integer startPosition) {
    return new Car(carName, startPosition);
  }

  @Override
  public void goForward(Car car, Integer goCost) {
    if (4 > goCost) {
      return;
    }
    car.setDistance(car.getDistance() + 1);
  }

  public String getDistanceWithString(Car car) {
    StringBuilder distanceString = new StringBuilder();
    for (int distance = 0; distance < car.getDistance(); ++distance) {
      distanceString.append("-");
    }
    return String.valueOf(distanceString);
  }
}
