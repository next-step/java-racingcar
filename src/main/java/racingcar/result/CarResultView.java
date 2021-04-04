package racingcar.result;

import racingcar.car.Car;

public class CarResultView {

  private final String carName;
  private final int currentPosition;
  
  public CarResultView(Car car) {
    this.carName = car.getCarName();
    this.currentPosition = car.getPosition();
  }

  public String getCarName() {
    return carName;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }

  public String generateCurrentSituation(String positionUnit) {
    StringBuilder builder = new StringBuilder();
    builder.append(this.carName)
        .append(" : ");
    for(int i = 0 ; i < currentPosition ; ++i) {
      builder.append(positionUnit);
    }
    return builder.toString();
  }
}
