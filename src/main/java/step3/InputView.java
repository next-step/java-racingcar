package step3;

import java.util.Scanner;

public class InputView {

  private static final String NUM_CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
  private static final String NUM_ROUND_QUESTION = "시도할 회수는 몇 회 인가요?";
  private final Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public int getNumCars() {
    System.out.println(NUM_CAR_QUESTION);
    return askInt();
  }

  public int getNumRounds() {
    System.out.println(NUM_ROUND_QUESTION);
    return askInt();
  }

  private int askInt() {
    return scanner.nextInt();
  }
}
