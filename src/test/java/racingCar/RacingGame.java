package racingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
  private int tryCount;
  private final List<Car> cars;

  public RacingGame(int carNumber, int tryCount) {
    cars = new ArrayList<>();
    for (int i=0; i < carNumber ; i++) {
      cars.add(new Car());
    }
    this.tryCount = tryCount;
  }

  public void start() {
    for (int i=0 ; i < tryCount ; i++) {
      cars.forEach(car -> car.move(RandomNumber.create()) );
    }
  }


}
