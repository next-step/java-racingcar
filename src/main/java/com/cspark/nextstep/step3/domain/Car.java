package com.cspark.nextstep.step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Car {

  private final String name;
  private final Function<Dice, Boolean> rule;
  private final List<Boolean> records;

  public Car(String name, Function<Dice, Boolean> rule) {
    this.name = name;
    this.rule = rule;
    this.records = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void drive(Dice dice) {
    records.add(rule.apply(dice));
  }

  public long forwardCount() {
    return records.stream()
        .filter(b -> b)
        .count();
  }

}
