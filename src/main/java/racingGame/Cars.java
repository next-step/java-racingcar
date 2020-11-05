package racingGame;

import racingGame.racingGameException.IllegalCarsInputRange;

import java.util.List;
import java.util.Vector;

public class Cars {

  private final List<Car> cars;

  private Cars(List<Car> cars) {
    this.cars = cars;
  }

  public static Cars of(List<Car> cars) {
    return new Cars(cars);
  }

  public static Cars of(int numCar) {
    if (numCar < 1) {
      throw new IllegalCarsInputRange();
    }

    List<Car> cars = new Vector<>();
    for (int i = 0; i < numCar; i++) {
      cars.add(new Car());
    }

    return of(cars);
  }

  public void moves(ScoreGenerator ScoreGenerator) {
    for (Car car : cars) {
      car.move(ScoreGenerator.generateScore());
    }
  }

  public List<Integer> getPositions() {
    List<Integer> positions = new Vector<>(cars.size());

    for (int i = 0; i < cars.size(); i++) {
      positions.add(i, cars.get(i).getPosition());
    }

    return positions;
  }

}
