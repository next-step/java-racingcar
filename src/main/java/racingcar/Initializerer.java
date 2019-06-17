package racingcar;

import java.util.Scanner;

public class Initializerer {

  Scanner scanner = new Scanner(System.in);
  private int numberOfCar;
  private int numberOfTimes;

  public void initNumberOfCar() {
    numberOfCar = scanner.nextInt();
  }

  public void initNumberOfTimes() {
    numberOfTimes = scanner.nextInt();
  }

  public int getNumberOfCar() {
    return numberOfCar;
  }

  public int getNumberOfTimes() {
    return numberOfTimes;
  }
}
