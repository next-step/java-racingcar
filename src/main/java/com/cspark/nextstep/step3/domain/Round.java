package com.cspark.nextstep.step3.domain;

import java.util.List;

public class Round {

  private List<Driver> drivers;

  public Round(List<Driver> drivers) {
    this.drivers = drivers;
  }

  public List<Driver> race(Dice dice) {
    for (Driver driver : drivers) {
      driver.drive(dice);
    }
    return drivers;
  }
}
