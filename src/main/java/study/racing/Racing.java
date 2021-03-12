package study.racing;

public class Racing {

  public static void main(String[] args) {
    int carCount = InputView.getCarCount();
    Cars cars = createCars(carCount);
    int tryCount = InputView.getTryCount();
    printResult(cars, tryCount);
  }

  private static void printResult(Cars cars, int tryCount) {
    for (int i = 0; i < tryCount; i++) {
      cars.moveByCondition();
      cars.printPosition();
      System.out.println("");
    }
  }

  public static Cars createCars(int carCount) {
    Cars cars = new Cars();
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car());
    }
    return cars;
  }

}
