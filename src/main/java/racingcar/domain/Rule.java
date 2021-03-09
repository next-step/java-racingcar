package racingcar.domain;

import java.util.Random;

public class Rule {

  private static final int MOVEABLE_CRITERIA = 4;
  private static final int RANDOM_NUMBER_BOUND = 10;

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
      racing(car);
    }
  }

  public int getRound() {
    return round;
  }

  public Cars getCars() {
    return cars;
  }

  private void racing(Car car) {
    if(isMoveable(randomNumber.nextInt(RANDOM_NUMBER_BOUND)))
      car.moveCar();
  }

  private boolean isMoveable(int randomNumber) {
    return randomNumber <= MOVEABLE_CRITERIA;
  }

  private Random generateRandomSeed() {
    return new Random(System.currentTimeMillis());
  }
}
