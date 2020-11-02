package racinggame.ui;

import static racinggame.message.MessageConstant.CAR_NAME_LENGTH_IS_UNDER_FIVE;
import static racinggame.message.MessageConstant.ENTER_THE_NAME_OF_THE_CAR;
import static racinggame.message.MessageConstant.HOW_MANY_ATTEMPT;
import static racinggame.message.MessageConstant.WRONG_INPUT;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import racinggame.vo.RacingInfo;

public class InputView {

  private InputView() {}

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final String WHITE_SPACE = "\n";
  private static final String COMMA = ",";
  private static final int MAX_CAR_NAME_LENGTH = 5;
  private static final String EMPTY_STRING = "";

  public static RacingInfo racingInfoForm() {
    String[] racingCarNames = getRacingCarNames();
    int roundCount = getRoundCount();

    return new RacingInfo(racingCarNames, roundCount);
  }

  private static String[] getRacingCarNames() {
    return queryAndAnswerForString(ENTER_THE_NAME_OF_THE_CAR);
  }

  private static int getRoundCount() {
    return queryAndAnswerForInt(HOW_MANY_ATTEMPT);
  }

  private static String[] queryAndAnswerForString(String query) {
    System.out.println(query);
    try {
      String racingCarNames = SCANNER.next();
      String[] splitCarName = splitRacingCarNames(racingCarNames);
      checkCarNameMaxLength(splitCarName);
      return splitCarName;
    } catch (InputMismatchException e) {
      throw new IllegalArgumentException(WRONG_INPUT);
    } finally {
      SCANNER.nextLine();
    }
  }

  private static int queryAndAnswerForInt(String query) {
    System.out.println(query);
    try {
      return SCANNER.nextInt();
    } catch (InputMismatchException e) {
      throw new IllegalArgumentException(WRONG_INPUT);
    } finally {
      SCANNER.nextLine();
    }
  }

  private static String[] splitRacingCarNames(String racingCarNames) {
    String splitString = racingCarNames.replaceAll(WHITE_SPACE, EMPTY_STRING);
    return splitString.split(COMMA);
  }

  private static void checkCarNameMaxLength(String[] splitCarName) {
    boolean isOverMaxLangth = Arrays.stream(splitCarName).anyMatch(carName -> carName.length() > MAX_CAR_NAME_LENGTH);
    if (isOverMaxLangth) {
      throw new IllegalArgumentException(CAR_NAME_LENGTH_IS_UNDER_FIVE);
    }
  }
}
