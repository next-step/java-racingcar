package racingGame.View;

import java.util.Scanner;

public class InputView {

  static final String NUM_CAR_QUESTION = "자동차 댓수는 몇 대 인가요?";
  static final String NUM_ROUND_QUESTION = "시도할 횟수는 몇 회 인가요?";

  Scanner scanner;

  private InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public static InputView createInstance() {
    return new InputView(new Scanner(System.in));
  }

  public int askNumCar() {
    System.out.println(NUM_CAR_QUESTION);
    return this.scanner.nextInt();
  }

  public int askNumRound() {
    System.out.println(NUM_ROUND_QUESTION);
    return this.scanner.nextInt();
  }

}
