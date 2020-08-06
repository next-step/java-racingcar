package com.cspark.nextstep.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Driver {

  private final String name;
  private final Function<Dice, Boolean> rule;
  private final List<Boolean> records;
  private final int FORWARD = 1;
  private final int STOP = 0;

  public Driver(String name, Function<Dice, Boolean> rule) {
    this.name = name;
    this.rule = rule;
    this.records = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List<Boolean> getRecords() {
    return records;
  }

  public int drive(Dice dice) {
    records.add(rule.apply(dice));
    return records.get(records.size() - 1) ? FORWARD : STOP;
  }

  public long forwardCount() {
    return records.stream()
        .filter(b -> b)
        .count();
  }

}
