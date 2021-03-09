package study.racing;

import java.util.ArrayList;

public class Racing {

  private ArrayList<Car> cars;

  public static void main(String[] args) {
    int carCount = InputView.getCarCount();
    int tryCount = InputView.getTryCount();
    Racing racing = new Racing();
    racing.cars = createCars(carCount, tryCount);
    printResult(tryCount, racing.cars);
  }

  private static ArrayList<Car> createCars(int carCount, int tryCount) {
    ArrayList<Car> cars = new ArrayList<>();
    for (int i = 0; i < carCount; i++) {
      Car car = new Car(tryCount);
      cars.add(car);
    }
    return cars;
  }

  private static void printResult(int tryCount, ArrayList<Car> cars) {
    for (int i = 0; i < tryCount; i++) {
      int tryNumber = i + 1;
      System.out.println("try : " + tryNumber);
      printResultByIndex(cars, i);
    }
  }

  private static void printResultByIndex(ArrayList<Car> cars, int index) {
    for (int i = 0; i < cars.size(); i++) {
      Car car = cars.get(i);
      car.checkMove(index);
      ResultView.printResult(car.getMoveCount());
    }
  }


}
