package racingcar.domain;

import java.util.Random;

public class Rule {
  private final int round;
  private final Cars cars;
  private final Random randomNumber;

  public Rule(int round, Cars cars) {
    this.round = round;
    this.cars = cars;
    this.randomNumber = generateRandomSeed();
  }

  public static Rule createRule(int round, Cars cars) {
    return new Rule(round, cars);
  }

  public void doRacing() {
    for(Car car : cars.getCars()){
      car.moveCar(randomNumber.nextInt(10));
    }
  }

  public int getRound() {
    return round;
  }

  private Random generateRandomSeed() {
    return new Random(System.currentTimeMillis());
  }
}
