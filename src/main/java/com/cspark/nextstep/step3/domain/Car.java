package com.cspark.nextstep.step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Car {

  private final String name;
  private final List<Boolean> records;

  public Car(String name) {
    this.name = name;
    this.records = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void drive(Supplier<Boolean> record) {
    records.add(record.get());
  }

  public long forwardCount() {
    return records.stream()
        .filter(b -> b)
        .count();
  }

}
