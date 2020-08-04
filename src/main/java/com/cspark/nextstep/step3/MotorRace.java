package com.cspark.nextstep.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MotorRace {

  private final Function<Dice, Boolean> rule = (d) -> d.cast() > 3;

  private List<Driver> drivers;
  private final int numberOfRepeats;
  private final Dice dice;

  public MotorRace(String[] driverNames, int numberOfRepeats) {
    this.drivers = createTeam(driverNames);
    this.numberOfRepeats = numberOfRepeats;
    this.dice = new Dice(0, 9);
  }

  private List<Driver> createTeam(String[] driverNames) {
    List<Driver> drivers = new ArrayList<>();
    for (String driverName : driverNames) {
      drivers.add(new Driver(driverName, rule));
    }

    return drivers;
  }

  public List<Driver> game() {
    for (int i = 0; i < numberOfRepeats; i++) {
      lap();
    }

    return drivers;
  }

  private void lap() {
    for (Driver driver : drivers) {
      driver.drive(dice);
    }
  }

  public List<Driver> podium() {
    return drivers = drivers.stream()
        .collect(Collectors.groupingBy(driver -> driver.forwardCount()))
        .entrySet().stream()
        .reduce((a, b) -> a.getKey() > b.getKey() ? a : b)
        .map(d -> d.getValue())
        .get();

  }

}
