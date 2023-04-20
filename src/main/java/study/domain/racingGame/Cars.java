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

  public Cars(CarNames names) {
    if (names == null || names.isEmpty()) {
      throw new IllegalArgumentException("차량 이름이 비어있습니다.");
    }
    this.value = new LinkedList<Car>();
    addCars(names);
    this.random = new Random();
  }

  private void addCars(CarNames names) {
    for (String carName : names) {
      this.value.add(new Car(carName));
    }
  }

  private void addCars(int carCnt) {
    for (int cnt = 0; cnt < carCnt; cnt++) {
      this.value.add(new Car(String.valueOf(cnt)));
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

  public CarNames getMaxDistanceCarNames() {
    int maxDistance = getMaxDistance();
    CarNames maxDistanceCarNames = new CarNames();
    for (Car car : this.value) {
      addMaxDistanceCarNames(maxDistance, maxDistanceCarNames, car);
    }
    return maxDistanceCarNames;
  }

  private void addMaxDistanceCarNames(int maxDistance, CarNames maxDistanceCarNames, Car car) {
    if (maxDistance != car.getTotalDistance()) {
      return;
    }
    maxDistanceCarNames.addName(car.getCarName());
  }

  private int getMaxDistance() {
    int maxDistance = 0;
    for (Car car : this.value) {
      maxDistance = Math.max(car.getTotalDistance(), maxDistance);
    }
    return maxDistance;
  }
}
