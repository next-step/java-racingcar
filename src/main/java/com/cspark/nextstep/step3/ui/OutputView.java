package com.cspark.nextstep.step3.ui;

import com.cspark.nextstep.step3.domain.Driver;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

  public static void displayLap(List<Driver> drivers) {
    for (Driver driver : drivers) {
      List<Boolean> records = driver.getRecords();
      printSkidMark(driver.getName(), records);
    }
    System.out.print(System.lineSeparator());
  }

  private static void printSkidMark(String name, List<Boolean> records) {
    String skidMark = records.stream()
        .filter(b -> b)
        .map(b -> "-")
        .collect(Collectors.joining());
    System.out.println(String.format("%5s : %s", name, skidMark));
  }

  public static void displayWinner(List<Driver> wins) {
    System.out.println(String.format("%s가 최종 우승했습니다.",
        wins.stream()
            .map(d -> d.getName())
            .collect(Collectors.joining(", ")))
    );
  }

}
