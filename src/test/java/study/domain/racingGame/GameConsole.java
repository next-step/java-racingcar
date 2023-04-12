package study.domain.racingGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameConsole {

  private Scanner scaner;

  public GameConsole() {
    scaner = new Scanner(System.in);
  }

  public void print(String printTxt) {
    System.out.println(printTxt);
  }

  public int inputInt() {
    int input = 0;
    try {
      input = scaner.nextInt();
    } catch (InputMismatchException e) {
      throw new RuntimeException("숫자만 입력해주세요");
    }
    return input;
  }
}
