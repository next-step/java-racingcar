package racingcar.view;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

  public static final Scanner SCANNER = new Scanner(System.in);
  private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
  private static final String DELIMITER = ",";

  public static List<String> getCarNames() {
    System.out.println(CAR_NAME_MESSAGE);
    return Arrays.asList(SCANNER.nextLine().split(DELIMITER));
  }

  public static int getTryCount() {
    System.out.println(TRY_COUNT_MESSAGE);
    return SCANNER.nextInt();
  }
}
