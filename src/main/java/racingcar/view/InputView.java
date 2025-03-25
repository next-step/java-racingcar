package racingcar.view;

import java.util.Scanner;

public class InputView {

  private static final String CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String ROUND_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
  private final Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public String[] readCarNames() {
    System.out.println(CAR_NAMES_QUESTION);
    String input = scanner.nextLine();
    return input.split(",");
  }

  public int readRoundCount() {
    System.out.println(ROUND_COUNT_QUESTION);
    return scanner.nextInt();
  }
}
