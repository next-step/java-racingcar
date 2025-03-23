package step4.carracing.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars implements Iterable<Car> {
  private final List<Car> carList;

  public Cars(List<Car> carList) {
    validate(carList);
    this.carList = carList;
  }

  private void validate(List<Car> carList) {
    if (carList == null || carList.isEmpty()) {
      throw new IllegalArgumentException("자동차가 없습니다.");
    }
    if (carList.stream().map(Car::getName).distinct().count() != carList.size()) {
      throw new IllegalArgumentException("중복된 이름의 자동차가 존재합니다.");
    }
  }

  public int getMaxPosition() {
    return carList.stream().reduce(0, (max, car) -> car.compareMaxPosition(max), Integer::max);
  }

  public Cars filterCarsWithCertainPosition(int position) {
    List<Car> filteredCars = carList.stream().filter(car -> car.isSamePosition(position)).collect(Collectors.toList());
    return new Cars(filteredCars);
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

  public Stream<Car> stream() {
    return carList.stream();
  }
}
