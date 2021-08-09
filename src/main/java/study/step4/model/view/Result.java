package study.step4.model.view;

import java.util.List;

import study.step4.model.car.Car;
import study.step4.model.car.Cars;

public class Result {

  private int carWinnerDistance = 0;

  private List<Car> racingGameCars;

  public Result(Cars cars) {
    racingGameCars = cars.getRacingGameCars();
  }

  public List<Car> getRacingGameCars() {
    return racingGameCars;
  }

  public void updateWinnerDistance() {
    for (Car car : racingGameCars) {
      setCarWinnerDistance(car.getDistance());
    }
  }

  private void setCarWinnerDistance(int carWinnerDistance) {
    if (this.carWinnerDistance < carWinnerDistance) {
      this.carWinnerDistance = carWinnerDistance;
    }
  }

  public int getCarWinnerDistance() {
    return carWinnerDistance;
  }
}
