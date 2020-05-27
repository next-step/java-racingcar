package racing_game.view;

public class RacingGameInputView {
  private static final String NAME_OF_CARS_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String NUMBER_OF_CARS_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
  private static final String TIME_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

  public static void printNameOfCarsInputMessage() {
    System.out.println(NAME_OF_CARS_INPUT_MESSAGE);
  }

  public static void printNumberOfCarsInputMessage() {
    System.out.println(NUMBER_OF_CARS_INPUT_MESSAGE);
  }

  public static void printTimeInputMessage() {
    System.out.println(TIME_INPUT_MESSAGE);
  }
}
