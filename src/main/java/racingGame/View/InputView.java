package racingGame.View;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import racingGame.racingGameException.IllegalNumCars;
import racingGame.racingGameException.IllegalNumRoundException;

public class InputView {

  private static final String NUM_CAR_QUESTION = "자동차 댓수는 몇 대 인가요?";
  private static final String USER_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String NUM_ROUND_QUESTION = "시도할 횟수는 몇 회 인가요?";

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static int askNumCar() {
    System.out.println(NUM_CAR_QUESTION);
    return scanner.nextInt();
  }

  public static String askUserNames() {
    String rawInput;
    List<String> parsedInput;

    System.out.println(USER_NAME_QUESTION);
    rawInput = scanner.nextLine();

    if (rawInput == null || rawInput.length() < 1) {
      throw new IllegalNumCars();
    }

    return rawInput;
  }

  public static List<String> parseRawInput(String rawInput) {
    if (rawInput == null || rawInput.length() < 1) {
      throw new IllegalArgumentException();
    }

    return new Vector<>(Arrays.asList(rawInput.split(",")));
  }

  public static int askNumRound() {
    System.out.println(NUM_ROUND_QUESTION);
    int round = scanner.nextInt();
    if (round < 1) {
      throw new IllegalNumRoundException();
    }

    return round;
  }
}
