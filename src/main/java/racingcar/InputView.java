package racingcar;

public class InputView {

  public static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
  public static final String QUESTION_TIMES_NUM = "시도할 회수는 몇 회 인가요?";

  public static void askNameOfCars() {
    print(QUESTION_CAR_NAMES);
  }

  public static void askNumberOfTimes() {
    print(QUESTION_TIMES_NUM);
  }

  private static void print(String content) {
    System.out.println(content);
  }
}
