package racingCar;

import java.util.Scanner;

public class InputView {
  public int inputByUser(String question) {
    System.out.println(question);
    return new Scanner(System.in).nextInt();
  }
}
