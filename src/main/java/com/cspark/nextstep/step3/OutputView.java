package com.cspark.nextstep.step3;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

  private int totalOfRepeats;
  private final List<Driver> drivers;

  public OutputView(int totalOfRepeats, List<Driver> drivers) {
    this.totalOfRepeats = totalOfRepeats;
    this.drivers = drivers;
  }

  public void displayLaps() {
    for (int lap = 0; lap < totalOfRepeats; lap++) {
      displayLap(lap);
      System.out.print("\n");
    }
  }

  private void displayLap(int lap) {
    for (Driver driver : drivers) {
      List<Boolean> records = driver.getRecords();
      printSkidMark(driver.getName(), records.subList(0, lap + 1));
    }
  }

  private void printSkidMark(String name, List<Boolean> records) {
    String skidMark = records.stream()
        .filter(b -> b)
        .map(b -> "-")
        .collect(Collectors.joining());
    System.out.println(String.format("%5s : %s", name, skidMark));
  }

  public void displayWinner(List<Driver> wins) {
    System.out.println(String.format("%s가 최종 우승했습니다.",
        wins.stream()
            .map(d -> d.getName())
            .collect(Collectors.joining(", ")))
    );
  }

}
