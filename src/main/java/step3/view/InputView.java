package step3.view;

import java.util.Scanner;

public class InputView {

  private InputView() { }

  public int inputCars () {
    Scanner scan = new Scanner(System.in);
    System.out.println("자동차 수는 몇 대 인가요?");;
    return Integer.parseInt(scan.nextLine());
  }

  public int inputTime () {
    Scanner scan = new Scanner(System.in);
    System.out.println("시도할 회수는 몇 회 인가요?");
    return Integer.parseInt(scan.nextLine());
  }

  public static InputView of () { return new InputView(); }
}
