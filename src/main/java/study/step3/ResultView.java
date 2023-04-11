package study.step3;

public class ResultView {

  static final private String FOOTPRINT = "-";

  private ResultView() {
  }

  static void printResult(int raceNum, Car[] cars) {
    printRaceNum(raceNum);
    printCars(cars);
  }

  private static void printRaceNum(int raceNum) {
    System.out.printf("\nRace%d\n", raceNum + 1);
  }

  private static void printCars(Car[] cars) {
    for (Car car : cars) {
      System.out.println(FOOTPRINT.repeat(car.getDistance()));
    }
  }
}
