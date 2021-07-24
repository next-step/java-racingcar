package study.racing.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import study.racing.common.Message;
import study.racing.exception.Exception;

public class InsertView {

  private static final Scanner scanner = new Scanner(System.in);

  public static String inputCarsNameWithMessage(String message) {
    printMessage(message);
    return scanner.nextLine();
  }

  public static int inputValueWithMessage(String message) {
    printMessage(message);
    int number = 0;

    try {
      number =  scanner.nextInt();
    }catch (InputMismatchException ie){
      Exception.InputMismatchException(Message.MSG_ERROR_VALUE_TYPE);
    }

    return number;
  }

  public static void printMessage(String text) {
    System.out.println(text);
  }

  public static void printNewLine() {
    System.out.print("\n");
  }

}
