package racingcar.step4.view;

import java.util.Scanner;

public class InputView {
  private static final String IS_NOT_NUMBER_FORMAT = "숫자 형식이 올바르지 않습니다. input: %s, errorMessage: %s";
  private static final String UNEXPECTED_ERROR = "예기치 못한 에러가 발생했습니다. input: %s, errorMessage: %s";
  private static final String NEGATIVE_NUMBER_OR_ZERO_IS_NOT_ALLOWED = "입력 값이 잘못되었습니다. 0이나 음수는 허용되지 않습니다. input: %s";

  public InputView() {}

  public InputValue receive() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    String carNames = scanner.nextLine();

    System.out.println("시도할 회수는 몇 회 인가요?");
    int tryCount = validateInputNumber(toInt(scanner.nextLine()));

    return new InputValue(carNames, tryCount);
  }

  private static int toInt(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException nfe) {
      throw new NumberFormatException(String.format(IS_NOT_NUMBER_FORMAT, input, nfe.getMessage()));
    } catch (Exception e) {
      throw new RuntimeException(String.format(UNEXPECTED_ERROR, input, e.getMessage()), e);
    }
  }

  private static int validateInputNumber(int number) {
    if (number <= 0) {
      throw new IllegalArgumentException(String.format(NEGATIVE_NUMBER_OR_ZERO_IS_NOT_ALLOWED, number));
    }
    return number;
  }
}
