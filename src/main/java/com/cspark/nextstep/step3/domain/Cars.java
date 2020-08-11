package com.cspark.nextstep.step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> cars;

  public Cars(String[] carNames) {
    this.cars = makeCars(carNames);
  }

  private List<Car> makeCars(String[] carNames) {
    List<Car> cars = new ArrayList<>();

    for (String carName : carNames) {
      cars.add(new Car(carName));
    }

    return cars;
  }

  public List<Scorecard> race(RaceRule raceRule, Dice dice) {
    for (Car car : cars) {
      car.drive(() -> raceRule.apply(dice));
    }
    return scorecard();
  }

  private List<Scorecard> scorecard() {
    return cars.stream()
        .map(Scorecard::of)
        .collect(Collectors.toList());
  }

  public List<Scorecard> podium() {
    return scorecard().stream()
        .collect(Collectors.groupingBy(Scorecard::getForwardCount))
        .entrySet().stream()
        .reduce((a, b) -> a.getKey() > b.getKey() ? a : b)
        .map(Entry::getValue)
        .get();
  }
}
