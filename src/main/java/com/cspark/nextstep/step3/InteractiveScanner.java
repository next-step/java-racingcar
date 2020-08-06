package com.cspark.nextstep.step3;

import java.util.List;
import java.util.Scanner;

public class InteractiveScanner {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    InputView inputView = new InputView(scanner);
    String[] driverNames = inputView.nameScript();
    int numberOfRepeats = inputView.repeatsScript();

    System.out.println(String.format("자동차 %d대, %d회 실행 결과", driverNames.length, numberOfRepeats));
    MotorRace motorRace = new MotorRace(driverNames, numberOfRepeats);
    List<Driver> drivers = motorRace.game();

    OutputView outputView = new OutputView(numberOfRepeats, drivers);

    outputView.displayLaps();
    outputView.displayWinner(motorRace.podium());
  }

}
