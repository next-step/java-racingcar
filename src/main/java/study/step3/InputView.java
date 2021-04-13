package study.step3;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static int inputCarNumber() {
    System.out.println(MessageUtil.carNumberMessage);
    int carNumber = SCANNER.nextInt();
    Validator.validatorNumber(carNumber);

    return carNumber;
  }

  public static int inputTimes() {
    System.out.println(MessageUtil.carTimesMessage);
    int times = SCANNER.nextInt();
    Validator.validatorNumber(times);

    return times;
  }

}
