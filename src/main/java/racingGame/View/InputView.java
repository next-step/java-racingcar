package racingGame.View;

import java.util.Scanner;

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
    System.out.println(USER_NAME_QUESTION);
    return scanner.nextLine();
  }

  public static int askNumRound() {
    System.out.println(NUM_ROUND_QUESTION);
    return scanner.nextInt();
  }
}
