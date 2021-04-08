package racingcar.car;

public class CarStatusDTO {

  private final String carName;
  private final int currentPosition;

  public CarStatusDTO(Car car) {
    this.carName = car.getCarName();
    this.currentPosition = car.getPosition();
  }

  public String getCarName() {
    return carName;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }

}
