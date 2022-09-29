package step3.view;

import java.util.Scanner;

public class InputView {

  private String ment;
  private Scanner scanner;

  private InputView(String ment, Scanner scanner) {
    this.ment = ment;
    this.scanner = scanner;
  }

  public static InputView create(String ment, Scanner scanner) {
    return new InputView(ment, scanner);
  }

  public int getInput() {
    System.out.println(ment);
    String value = scanner.nextLine();
    try{
      return Integer.parseInt(value);
    }catch (Exception e) {
      return getInput();
    }
  }

}
