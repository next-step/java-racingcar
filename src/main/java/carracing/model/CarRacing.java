package carracing.model;

import carracing.view.InputView;
import carracing.view.ResultView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRacing {

  private final Integer totalRound;
  private Integer presentRound;
  private List<Car> cars;

  public CarRacing(Integer totalRound, Integer carCount) {
    this.totalRound = totalRound;
    this.presentRound = 0;
    this.cars = Stream.generate(Car::new).limit(carCount).collect(Collectors.toList());
  }

  public CarRacing(InputView inputView) {
    Integer carCount = inputView.getCarCount();
    this.cars = Stream.generate(Car::new).limit(carCount).collect(Collectors.toList());
    this.totalRound = inputView.getTotalRound();
    this.presentRound = 0;
  }

  public List<Car> getCars() {
    return cars;
  }

  public Integer getTotalRound() {
    return totalRound;
  }

  public void proceedOneRound() {
    cars.forEach(Car::move);
  }

  public void race(boolean showResult) {
    for (; presentRound < totalRound; presentRound++) {
      proceedOneRound();
    }

    if (showResult) {
      new ResultView(this).show();
    }
  }
}
