package racingcar.ui;

public class InputView {
  private static final String ASK_CAR_NUMBERS = "자동차 대수는 몇 대 인가요?";
  private static final String ASK_TRIAL_NUMBERS = "자동차 대수는 몇 대 인가요?";

  public void askCarNumbers() {
    Printer.print(ASK_CAR_NUMBERS);
  }

  public void askTrialNumbers() {
    Printer.print(ASK_TRIAL_NUMBERS);
  }
}
