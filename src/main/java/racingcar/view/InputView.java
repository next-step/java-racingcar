package racingcar.view;

import java.util.Scanner;

public class InputView {

  private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
  private static final String ROUND_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
  private final Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public int getCarCount() {
    System.out.println(CAR_COUNT_QUESTION);
    return askInt();
  }

  public int getRoundCount() {
    System.out.println(ROUND_COUNT_QUESTION);
    return askInt();
  }

  private int askInt() {
    return scanner.nextInt();
  }
}
