package core.car;

import core.util.Util;

public class CarImpl implements CarInterface {

  Car car;
  Util util;

  public CarImpl(Car car, Util util) {
    this.car = car;
    this.util = util;
  }

  @Override
  public void goForward(Integer goCost) {
    if (4 > goCost) {
      return;
    }
    car.setDistance(car.getDistance() + 1);
  }

  @Override
  public Integer getRandomNum() {
    double dValue = Math.random();
    return (Integer) (int) (dValue * 10);
  }

  @Override
  public String getCarName() {
    return car.getName();
  }

  @Override
  public String getDistance() {
    StringBuilder distanceString = new StringBuilder();
    for (int distance = 0; distance < car.getDistance(); ++distance) {
      distanceString.append("-");
    }
    return String.valueOf(distanceString);
  }
}
