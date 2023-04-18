package racingcar.ui;

import java.util.Scanner;
import racingcar.dto.CarNames;
import racingcar.dto.TrialNumber;

public class InputView {
  private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String ASK_TRIAL_NUMBERS = "시도할 횟수는 몇 회 인가요?";
  private static final Scanner scanner = new Scanner(System.in);

  public CarNames askCarNames() {
    Printer.println(ASK_CAR_NAMES);
    return new CarNames(scanner.nextLine());
  }

  public TrialNumber askTrialNumbers() {
    Printer.println(ASK_TRIAL_NUMBERS);
    return new TrialNumber(scanner.nextLine());
  }
}
