package study.racinggame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static study.racinggame.util.NumberValidator.validatedPositive;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);
  private static final String carMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String tryMessage = "시도할 횟수는 몇 회 인가요?";
  private static final String DELIMITER = ",";

  public static List<String> inputCarNames() {
    System.out.println(carMessage);

    return splitNames(scanner.nextLine());
  }

  public static int inputTryNumber() {
    System.out.println(tryMessage);
    return validatedPositive(scanner.nextInt());
  }

  private static List<String> splitNames(String carNames) {
    return Arrays.stream(carNames.split(DELIMITER))
            .collect(Collectors.toList());
  }
}
