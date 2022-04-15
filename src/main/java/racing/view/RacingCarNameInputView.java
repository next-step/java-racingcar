package racing.view;

import java.util.Scanner;
import racing.exception.UserInputFailException;

public class RacingCarNameInputView {

  private final Scanner scanner;

  public RacingCarNameInputView() {
    this.scanner = new Scanner(System.in);
  }

  public String getRacingCarNames() {
    try {
      return getRacingCarNames(scanner);
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

  private String getRacingCarNames(Scanner scanner) {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    return scanner.nextLine();
  }

  private int getRacingAttemptCount(Scanner scanner) {
    System.out.println("시도할 횟수는 몇 회 인가요?");
    return scanner.nextInt();
  }
}
