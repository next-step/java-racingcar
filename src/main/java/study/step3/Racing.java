package study.step3;

import java.util.Random;

public class Racing {

  static final private Random RANDOM_INSTANCE = new Random();

  private Racing() {
  }

  static void play(Car[] cars, int numOfRaces) {
    for (int i = 0; i < numOfRaces; i++) {
      moveCars(cars);
      ResultView.printResult(i + 1, cars);
    }
  }

  private static void moveCars(Car[] cars) {
    for (Car car : cars) {
      car.move(RANDOM_INSTANCE.nextInt(10));
    }
  }
}
