package com.cspark.nextstep.step3.ui;

import java.util.Scanner;
import java.util.function.Function;

public class InputView {

  private final Function<Scanner, String[]> question1 = (s) -> s.next().split(",");
  private final Function<Scanner, Integer> question2 = (s) -> s.nextInt();

  private static final String SCRIPT_Q_NAME = "경주할 자동차 이름을 입력하세요(공백불가, 이름은 쉼표(,)를 기준으로 구분).";
  private static final String SCRIPT_Q_REPEATS = "시도할 회수는 몇 회 인가요?";

  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public String[] nameScript() {
    System.out.println(SCRIPT_Q_NAME);
    return question1.apply(scanner);
  }

  public int roundScript() {
    System.out.println(SCRIPT_Q_REPEATS);
    return question2.apply(scanner);
  }

  public void printDashboard(int numberOfDrivers, int roundCount) {
    System.out.println(String.format("자동차 %d대, %d회 실행 결과", numberOfDrivers, roundCount));
  }

}
