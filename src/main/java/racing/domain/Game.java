package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 게임 - 자동차 수, 시도 횟수 관리
 *
 */
public class Game {

  private final MovementStrategy random;
  private final List<Car> cars;
  private final int tryCnt;

  public Game(MovementStrategy random, int carCnt, int tryCnt) {
    this.random = random;
    this.cars = initCars(carCnt);
    this.tryCnt = tryCnt;
  }

  private List<Car> initCars(int cnt){
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < cnt; i++) {
      cars.add(new Car());
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
