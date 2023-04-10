package racingcar.ui;

import java.util.Scanner;
import racingcar.dto.CarNumber;
import racingcar.dto.TrialNumber;

public class InputView {
  private static final String ASK_CAR_NUMBERS = "자동차 대수는 몇 대 인가요?";
  private static final String ASK_TRIAL_NUMBERS = "시도할 횟수는 몇 회 인가요?";
  private static final Scanner scanner = new Scanner(System.in);

  public CarNumber askCarNumbers() {
    Printer.println(ASK_CAR_NUMBERS);
    return new CarNumber(scanner.nextLine());
  }

  public TrialNumber askTrialNumbers() {
    Printer.println(ASK_TRIAL_NUMBERS);
    return new TrialNumber(scanner.nextLine());
  }
}
