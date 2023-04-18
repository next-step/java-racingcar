package study.domain.racingGame;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Cars implements Iterable<Car> {

  private List<Car> carList;
  private Random random;

  public Cars() {
    this.carList = new LinkedList<Car>();
    this.random = new Random();
  }

  public void addCars(int carCnt) {
    for (int cnt = 0; cnt < carCnt; cnt++) {
      this.carList.add(new Car());
    }
  }

  public int getTotalCarsCount() {
    return this.carList.size();
  }

  public void moveAll() {
    for (Car car : this.carList) {
      car.move(getRandomValue());
    }
  }

  private int getRandomValue() {
    return this.random.nextInt(9);
  }

  @Override
  public Iterator<Car> iterator() {
    return this.carList.iterator();
  }
}
