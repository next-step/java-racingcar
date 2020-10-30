package racinggame.ui;

import static racinggame.message.MessageConstant.HOW_MANY_ATTEMPT;
import static racinggame.message.MessageConstant.HOW_MANY_CARS;
import static racinggame.message.MessageConstant.WRONG_INPUT;

import java.util.InputMismatchException;
import java.util.Scanner;
import racinggame.vo.RacingInfo;

public class InputView {

  private InputView() {
  }

  private static final Scanner SCANNER = new Scanner(System.in);

  public static RacingInfo racingInfoForm() {
    int racingCarCount = getRacingCarCount();
    int roundCount = getRoundCount();

    return new RacingInfo(racingCarCount, roundCount);
  }

  private static int getRacingCarCount() {
    return queryAndAnswer(HOW_MANY_CARS);
  }

  private static int getRoundCount() {
    return queryAndAnswer(HOW_MANY_ATTEMPT);
  }

  private static int queryAndAnswer(String query) {
    System.out.println(query);
    try {
      return SCANNER.nextInt();
    } catch (InputMismatchException e) {
      throw new IllegalArgumentException(WRONG_INPUT);
    } finally {
      SCANNER.nextLine();
    }
  }
}
