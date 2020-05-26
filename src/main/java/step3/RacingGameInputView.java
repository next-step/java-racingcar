package step3;

public class RacingGameInputView {
  private static final String NUMBER_OF_CARS_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
  private static final String TIME_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

  public static void printNumberOfCarsInputMessage() {
    System.out.println(NUMBER_OF_CARS_INPUT_MESSAGE);
  }

  public static void printTimeInputMessage() {
    System.out.println(TIME_INPUT_MESSAGE);
  }
}
