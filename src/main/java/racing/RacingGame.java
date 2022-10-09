package racing;

import java.util.Scanner;

public class RacingGame {
  public static final Scanner input = new Scanner(System.in);

  public void start() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    int numberOfCar = input.nextInt();
    System.out.println("시도할 횟수는 몇 회 인가요?");
    int numberOfChance = input.nextInt();
    System.out.println("실행 결과");

    Cars cars = new Cars(numberOfCar);

    for (int i = 0; i < numberOfChance; i++) {
      cars.move();
      System.out.println();
    }
  }
}
