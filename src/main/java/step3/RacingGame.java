package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

  public static final int BOUNDARY = 9;

  public void start() {
    final Scanner scanner = new Scanner(System.in);
    System.out.println("자동차 대수는 몇 대 인가요?");
    final int numberOfCars = scanner.nextInt();
    System.out.println("시도할 회수는 몇 회 인가요?");
    final int numberOfAttempts = scanner.nextInt();

    final List<Car> cars = new ArrayList<>();
    for (int i = 0; i < numberOfCars; i++) {
      cars.add(new Car());
    }

    final StringBuilder output = new StringBuilder("실행 결과\n");
    Random random = new Random();

    for (int i = 0; i < numberOfAttempts; i++) {
      attempts(cars, random, output);
      output.append("\n");
    }

    System.out.println(output.toString());
  }

  private void attempts(List<Car> cars, Random random, StringBuilder output) {
    for (Car car : cars) {
      car.move(random.nextInt(BOUNDARY));
      final int location = car.getLocation();
      append(output, location);
    }
  }

  private void append(StringBuilder sb, int location) {
    sb.append("-");
    sb.append("-".repeat(location));
    sb.append("\n");
  }

}
