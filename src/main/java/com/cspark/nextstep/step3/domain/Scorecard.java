package com.cspark.nextstep.step3.domain;

public class Scorecard {

  private final String name;
  private final long forwardCount;

  Scorecard(String name, long forwardCount) {
    this.name = name;
    this.forwardCount = forwardCount;
  }

  public String getName() {
    return name;
  }


  public long getForwardCount() {
    return forwardCount;
  }

  public static Scorecard of(Car car) {
    return new Scorecard(car.getName(), car.forwardCount());
  }
}
