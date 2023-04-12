package study.domain.racingGame;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Cars implements Iterable<Car> {

  private List<Car> carList;

  public Cars() {
    carList = new LinkedList<Car>();
  }

  public void addCars(int carCnt) {
    for (int cnt = 0; cnt < carCnt; cnt++) {
      carList.add(new Car());
    }
  }

  public int findTotalCarsCount() {
    return carList.size();
  }

  public void moveAll() {
    for (Car car : carList) {
      car.move();

    }
  }

  @Override
  public Iterator<Car> iterator() {
    return carList.iterator();
  }
}
