package racingCar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingCar.view.OutputView;

public class Cars {


  private List<Car> cars;

  public Cars(List<Car> cars) {

    this.cars = cars;
  }

  public void move(OutputView outputView) {
    this.cars.forEach(car -> {
      car.move(new RandomMovable());
      outputView.printCarDistance(car);
    });

  }

  public List<Car> determineWinners() {
    int max = getMaxPosition(cars);

    return cars.stream()
        .filter(car -> car.getPosition() == max)
        .collect(Collectors.toList());
  }

  private int getMaxPosition(List<Car> cars) {
    return cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(-1);
  }
}
