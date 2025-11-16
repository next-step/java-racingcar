package racing.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static int inputTryCnt(Message message) {
    System.out.println(message.getMessage());
    while (true) {
      try {
        return scanner.nextInt();
      } catch (Exception e) {
        System.out.println("올바른 숫자를 입력해주세요:");
        scanner.nextLine();
      }
    }
  }

  public static String inputCar(Message message) {
    System.out.println(message.getMessage());
    String line = scanner.next();
    return line;
  }

  public static void close() {
    scanner.close();
  }
}