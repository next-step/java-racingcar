package carracing.model;

import carracing.util.ProbabilityUtil;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

  private final Integer totalRound;
  private Integer presentRound;
  private List<Car> cars;

  public CarRacing(List<String> carNames, Integer totalRound) {
    this.totalRound = totalRound;
    this.presentRound = 0;
    this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
  }

  public List<Car> getCars() {
    return cars;
  }

  public void proceedOneRound() {
    cars.forEach(car -> car.move(ProbabilityUtil.FOURTY_PERCENT));
  }

  public List<Car> race() {
    for (; presentRound < totalRound; presentRound++) {
      proceedOneRound();
    }

    return cars;
  }
}
