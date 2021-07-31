package study.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarRacingGame {

  private List<Car> racingGameCars;
  private int racingGameRepeatNumber;

  private static final int moveStandardNumber = 4;

  public CarRacingGame() {
    racingGameCars = new ArrayList();
  }

  public int getCarNumber() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    Scanner scanner = new Scanner(System.in);
    int carNumber = scanner.nextInt();
    setCars(carNumber);
    return carNumber;
  }

  void setCars(int carNumber) {
    for (int i = 0; i < carNumber; i++) {
      racingGameCars.add(new Car());
    }
  }

  public int getRacingGameRepeatNumber() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    Scanner scanner = new Scanner(System.in);
    racingGameRepeatNumber = scanner.nextInt();
    setRacingGameRepeatNumber(racingGameRepeatNumber);
    return racingGameRepeatNumber;
  }

  void setRacingGameRepeatNumber(int racingGameRepeatNumber) {
    this.racingGameRepeatNumber = racingGameRepeatNumber;
  }

  public int move() {

    int movedCar = 0;

    for (Car car : racingGameCars) {
      int getNumber = getRandomNumber();
      if (getNumber >= moveStandardNumber) {
        car.distance++;
        movedCar++;
      }
    }

    return movedCar;
  }

  private int getRandomNumber() {
    Random random = new Random();
    random.setSeed(System.currentTimeMillis() * random.nextInt());
    return random.nextInt(10);
  }

  public List getRacingGameCars() {
    return racingGameCars;
  }

  public void start() {
    getCarNumber();
    int gameRepeatNumber = getRacingGameRepeatNumber();

    while (gameRepeatNumber-- > 0) {
      move();
    }
  }
}
