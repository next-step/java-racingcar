package racingcar;

public class InputView {

  public static final String QUESTION_CAR_NUM = "자동차 대수는 몇 대 인가요?";
  public static final String QUESTION_TIMES_NUM = "시도할 회수는 몇 회 인가요?";

  public static void askNumberOfCar() {
    print(QUESTION_CAR_NUM);
  }

  public static void askNumberOfTimes() {
    print(QUESTION_TIMES_NUM);
  }

  private static void print(String content) {
    System.out.println(content);
  }
}
