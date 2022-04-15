package racing.view;

import java.util.Scanner;
import racing.exception.UserInputFailException;

public class RacingInputView {

  private final Scanner scanner;

  public RacingInputView() {
    this.scanner = new Scanner(System.in);
  }

  public int getRacingCarCount() {
    try {
      return getRacingCarCount(scanner);
    } catch (RuntimeException e) {
      throw new UserInputFailException(e);
    }
  }

  public int getRacingAttemptCount() {
    try {
      return getRacingAttemptCount(scanner);
    } catch (RuntimeException e) {
      throw new UserInputFailException(e);
    }
  }

  private int getRacingCarCount(Scanner scanner) {
    System.out.println("자동차 대수는 몇 대 인가요?");
    return scanner.nextInt();
  }

  private int getRacingAttemptCount(Scanner scanner) {
    System.out.println("시도할 횟수는 몇 회 인가요?");
    return scanner.nextInt();
  }
}
