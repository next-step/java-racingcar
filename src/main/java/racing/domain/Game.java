package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 게임 - 자동차 수, 시도 횟수 관리
 *
 */
public class Game {

  private final MovementStrategy random;
  private final List<Car> cars;
  private final int tryCnt;

  public Game(MovementStrategy random, List<CarName> carNames, int tryCnt) {
    this.random = random;
    this.cars = initCars(carNames);
    this.tryCnt = tryCnt;
  }

  private List<Car> initCars(List<CarName> carNames){
    List<Car> cars = new ArrayList<>();
    for (CarName name : carNames) {
      cars.add(new Car(name));
    }
    return cars;
  }

  public void play() {
    for (Car car : cars) {
      car.move(random.generate());
    }
  }

  public List<Car> getCars() {
    return Collections.unmodifiableList(cars);
  }

  public int getTryCnt() {
    return this.tryCnt;
  }

}
