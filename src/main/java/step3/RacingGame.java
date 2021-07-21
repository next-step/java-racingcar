package step3;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {

  public void start() {
    final Scanner scanner = new Scanner(System.in);
    System.out.println("자동차 대수는 몇 대 인가요?");
    final int numberOfCars = scanner.nextInt();
    System.out.println("시도할 회수는 몇 회 인가요?");
    final int numberOfAttempts = scanner.nextInt();
    final Cars cars = new Cars(numberOfCars);

    final StringBuilder output = new StringBuilder("실행 결과\n");
    Random random = new Random();

    for (int i = 0; i < numberOfAttempts; i++) {
      cars.move(random, output);
    }

    System.out.println(output.toString());
  }
}
