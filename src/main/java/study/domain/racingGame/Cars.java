package study.domain.racingGame;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Cars implements Iterable<Car> {

  private List<Car> value;
  private Random random;

  public Cars(int carNum) {
    this.value = new LinkedList<Car>();
    addCars(carNum);
    this.random = new Random();
  }

  private void addCars(int carCnt) {
    for (int cnt = 0; cnt < carCnt; cnt++) {
      this.value.add(new Car());
    }
  }

  public int getTotalCarsCount() {
    return this.value.size();
  }

  public Car get(int idx) {
    return this.value.get(idx);
  }

  public void moveAll() {
    for (Car car : this.value) {
      car.move(getRandomValue());
    }
  }

  private int getRandomValue() {
    return this.random.nextInt(9);
  }

  @Override
  public Iterator<Car> iterator() {
    return this.value.iterator();
  }
}
