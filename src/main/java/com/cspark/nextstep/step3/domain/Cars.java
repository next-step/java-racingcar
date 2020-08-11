package com.cspark.nextstep.step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cars {

  private final int roundCount;
  private final List<Car> cars;

  private int currentCount = 0;

  public Cars(int roundCount, String[] carNames, Function<Dice, Boolean> rule) {
    this.roundCount = roundCount;
    this.cars = makeCars(carNames, rule);
  }

  private List<Car> makeCars(String[] carNames, Function<Dice, Boolean> rule) {
    List<Car> cars = new ArrayList<>();

    for (String carName : carNames) {
      cars.add(new Car(carName, rule));
    }

    return cars;
  }

  public List<Scorecard> race(Dice dice) {
    currentCount++;
    for (Car car : cars) {
      car.drive(dice);
    }
    return scorecard();
  }

  private List<Scorecard> scorecard() {
    return cars.stream()
        .map(Scorecard::of)
        .collect(Collectors.toList());
  }

  public boolean hasNextLap() {
    return currentCount < roundCount;
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
