package com.cspark.nextstep.step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DriverUtil {

  public static List<Driver> makeDrivers(String[] driverNames, Function<Dice, Boolean> rule) {
    List<Driver> drivers = new ArrayList<>();

    for (String driverName : driverNames) {
      drivers.add(new Driver(driverName, rule));
    }

    return drivers;
  }
}
