package carracing.model;

import carracing.util.ProbabilityUtil;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

  private final Integer totalRound;
  private List<Car> cars;

  public CarRacing(List<String> carNames, Integer totalRound) {
    this.totalRound = totalRound;
    this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
  }

  public Integer getTotalRound() {
      return totalRound;
  }
  public List<Car> getCars() {
    return cars;
  }

  public void proceedOneRound() {
    cars.forEach(car -> car.move(ProbabilityUtil.FOURTY_PERCENT));
  }

  public void race() {
    for (int presentRound = 0; presentRound < totalRound; presentRound++) {
      proceedOneRound();
    }
  }
}
