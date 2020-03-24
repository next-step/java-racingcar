package carracing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
  private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String TOTAL_ROUND_QUESTION = "시도할 회수는 몇 회 인가요?";
  private static final String CAR_NAME_DELIMETER = ",";

  private Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public List<String> getCarNames() {
    System.out.println(CAR_NAME_QUESTION);
    String carNamesString = scanner.nextLine();
    return Arrays.asList(carNamesString.split(CAR_NAME_DELIMETER));
  }

  public Integer getTotalRound() {
    System.out.println(TOTAL_ROUND_QUESTION);
    return scanner.nextInt();
  }
}
