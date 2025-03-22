package step4.carracing.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars implements Iterable<Car> {
  private final List<Car> carList;

  public Cars(List<Car> carList) {
    this.carList = carList;
  }

  public int getMaxPosition() {
    return carList.stream().reduce(0, (max, car) -> car.getMax(max), Integer::max);
  }

  public Cars filterCarsWithCertainPosition(int position) {
    List<Car> filteredCars = carList.stream().filter(car -> car.isSame(position)).collect(Collectors.toList());
    return new Cars(filteredCars);
  }

  public void moveCars() {
    for (Car car : carList) {
      car.move();
    }
  }

  public int size() {
    return carList.size();
  }

  public Car get(String name) {
    return carList.stream()
      .filter(car -> car.getName().equals(name))
      .findFirst()
      .orElseThrow(() -> new IllegalArgumentException("해당 이름의 차량이 없습니다."));
  }

  @Override
  public Iterator<Car> iterator() {
    return carList.iterator();
  }

  public Stream<Car> stream() {
    return carList.stream();
  }

}
