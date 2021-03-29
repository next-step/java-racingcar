package racingcar;

import java.util.Scanner;

public class InputView {

  private final Scanner scanner;

  private static final String CAR_COUNT_INPUT_REQUIRE = "자동차 대수는 몇 대 인가요?";
  private static final String TRY_COUNT_INPUT_REQUIRE = "시도할 회수는 몇 회 인가요?";

  public InputView() {
    this(new Scanner(System.in));
  }

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public RacingRule requireRacingRule() {
    int carCount = this.requireCarCount();
    int tryCount = this.requireTryCount();
    return new RacingRule(carCount, tryCount);
  }

  private int requireCarCount() {
    System.out.println(CAR_COUNT_INPUT_REQUIRE);
    return this.scanner.nextInt();
  }

  private int requireTryCount() {
    System.out.println(TRY_COUNT_INPUT_REQUIRE);
    return this.scanner.nextInt();
  }
}
