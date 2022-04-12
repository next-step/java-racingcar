package racing.view;

import java.util.Scanner;
import racing.dto.RacingInput;
import racing.exception.UserInputFailException;

public class RacingInputView {

  public RacingInput printAndGetRacingInput() {
    try (Scanner scanner = new Scanner(System.in)) {
      return printAndGetRacingInput(scanner);
    } catch (RuntimeException e) {
      throw new UserInputFailException(e);
    }
  }

  private RacingInput printAndGetRacingInput(Scanner scanner) {
    RacingInput racingInput = new RacingInput();

    System.out.println("자동차 대수는 몇 대 인가요?");
    racingInput.setCarCount(scanner.nextInt());

    System.out.println("시도할 횟수는 몇 회 인가요?");
    racingInput.setAttemptCount(scanner.nextInt());

    return racingInput;
  }

}
