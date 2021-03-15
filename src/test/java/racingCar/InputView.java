package racingCar;

import java.util.Scanner;

public class InputView {

  private static final String CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
  private static final String TRY_QUESTION = "시도할 회수는 몇 회 인가요?";
  private final Scanner scanner = new Scanner(System.in);;

  public String[] inputCarNames() {
    System.out.println(CAR_QUESTION);
    return inputNames();
  }

  public int inputTryCount() {
    System.out.println(TRY_QUESTION);
    return inputNumber();
  }

  private String[] inputNames() {
    String carNames = scanner.next();
    return carNames.split(",");
  }

  private int inputNumber() {
    return scanner.nextInt();
  }

}
