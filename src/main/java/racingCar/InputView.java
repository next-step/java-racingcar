package racingCar;

import java.util.Scanner;

public class InputView {

  Scanner scanner;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public int inputInteger() {
    return scanner.nextInt();
  }
}
