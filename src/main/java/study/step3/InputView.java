package study.step3;

import java.util.Scanner;

public class InputView {

  private final Scanner SCANNER = new Scanner(System.in);

  public InputView() {
  }

  public int inputCarNumber() {
    System.out.println(MessageUtil.carNumberMessage);
    int carNumber = SCANNER.nextInt();
    Validator.validatorNumber(carNumber);

    return carNumber;
  }

  public int inputTimes() {
    System.out.println(MessageUtil.carTimesMessage);
    int times = SCANNER.nextInt();
    Validator.validatorNumber(times);

    return times;
  }

}
