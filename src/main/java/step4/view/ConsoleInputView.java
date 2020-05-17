package step4.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

  private static final Scanner SCAN = new Scanner(System.in);

  private ConsoleInputView () { }

  @Override
  public String inputCars () {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    return SCAN.nextLine();
  }

  @Override
  public int inputTime () {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return Integer.parseInt(SCAN.nextLine());
  }

  public static InputView of () { return new ConsoleInputView(); }
}
