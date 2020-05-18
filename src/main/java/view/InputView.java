package view;

import java.util.Scanner;

public class InputView {

  public static String carInputMessage = "자동차 대수는 몇 대인가요?";
  public static String attemptInputMessage = "시도할 회수는 몇 회인가요?";

  public static Integer getUserInput(String message) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(message);
    return scanner.nextInt();
  }
}
