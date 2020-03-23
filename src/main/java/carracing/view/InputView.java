package carracing.view;

import java.util.Scanner;

public class InputView {
  private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
  private static final String TOTAL_ROUND_QUESTION = "시도할 회수는 몇 회 인가요?";

  private Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public Integer getCarCount() {
    System.out.println(CAR_COUNT_QUESTION);
    return scanner.nextInt();
  }

  public Integer getTotalRound() {
    System.out.println(TOTAL_ROUND_QUESTION);
    return scanner.nextInt();
  }
}
