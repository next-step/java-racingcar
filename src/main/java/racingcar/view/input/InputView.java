package racingcar.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.racing.RacingRule;

public class InputView {

  private final Scanner scanner;

  public static final String CAR_NAME_SEPARATOR = ",";
  private static final String CAR_NAME_INPUT_REQUIRE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String TRY_COUNT_INPUT_REQUIRE = "시도할 회수는 몇 회 인가요?";

  public InputView() {
    this(new Scanner(System.in));
  }

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public RacingRule requireRacingRule() {
    List<String> carList = this.requireCarNames();
    int tryCount = this.requireTryCount();
    return new RacingRule(carList, tryCount);
  }

  private List<String> requireCarNames() {
    System.out.println(CAR_NAME_INPUT_REQUIRE);
    String[] split = this.scanner
        .next()
        .split(CAR_NAME_SEPARATOR);
    return Arrays.asList(split);
  }

  private int requireTryCount() {
    System.out.println(TRY_COUNT_INPUT_REQUIRE);
    return this.scanner.nextInt();
  }
}
