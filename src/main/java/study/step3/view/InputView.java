package study.step3.view;

import java.util.Scanner;
import study.step3.utils.MessageUtil;
import study.step3.validator.Validator;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  private InputView() {}

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

  public static String[] inputNames() {
    System.out.println(MessageUtil.carNamesMessage);

    String inputName = SCANNER.nextLine();

    String[] names = inputName.split(",");

    Validator.validatorNames(names);

    return names;
  }

}
