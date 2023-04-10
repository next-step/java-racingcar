package study.step3;

public class ResultView {

  private ResultView() {
  }

  static void printResult(int raceNum, Car[] cars) {
    System.out.printf("\nRace%d\n", raceNum);
    printCars(cars);
  }

  private static void printCars(Car[] cars) {
    for (Car car : cars) {
      System.out.println(car);
    }
  }
}
