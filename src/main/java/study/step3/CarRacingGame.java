package study.step3;

import java.util.Scanner;

public class CarRacingGame {

  public int getCarNumber() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public int getRacingGameRepeatNumber() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

}
