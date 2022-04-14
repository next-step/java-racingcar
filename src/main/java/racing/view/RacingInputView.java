package racing.view;

import java.util.Scanner;
import racing.exception.UserInputFailException;

public class RacingInputView {

  private int carCount;
  private int attemptCount;

  public void setRacingUserInput() {
    try (Scanner scanner = new Scanner(System.in)) {
      setRacingUserInput(scanner);
    } catch (RuntimeException e) {
      throw new UserInputFailException(e);
    }
  }

  private void setRacingUserInput(Scanner scanner) {
    System.out.println("자동차 대수는 몇 대 인가요?");
    this.carCount = scanner.nextInt();

    System.out.println("시도할 횟수는 몇 회 인가요?");
    this.attemptCount = scanner.nextInt();
  }

  public int getCarCount() {
    return carCount;
  }

  public int getAttemptCount() {
    return attemptCount;
  }
}
