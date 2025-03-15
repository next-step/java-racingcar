package racing.simulator;

public class CarRacingGameSimulator {

  private static final int MIN_CAR_COUNT = 2;
  private static final int MIN_SIMULATE_COUNT = 1;

  private final int carCount;
  private final CarMoveDecider carMoveDecider;
  private final Car[] cars;

  public CarRacingGameSimulator(int carCount, CarMoveDecider carMoveDecider) {
    checkNotValidCarCount(carCount);

    this.carCount = carCount;
    this.carMoveDecider = carMoveDecider;
    this.cars = new Car[carCount];
    for (int i = 0; i < carCount; i++) {
      cars[i] = new Car();
    }
  }

  public static void checkNotValidCarCount(int carCount) {
    if (carCount < MIN_CAR_COUNT) {
      throw new IllegalArgumentException("자동차 수는 최소 " + MIN_CAR_COUNT + "대여야 합니다.");
    }
  }

  public static void checkNotValidSimulateCount(int simulateCount) {
    if (simulateCount < MIN_SIMULATE_COUNT) {
      throw new IllegalArgumentException("시뮬레이션 횟수는 최소 " + MIN_SIMULATE_COUNT + "회여야 합니다.");
    }
  }

  public void tryMoveCars() {
    for (Car car: cars) {
      if (this.carMoveDecider.canMove()) {
        car.go();
      }
    }
  }

  public Car[] copyCars() {
    Car[] res = new Car[carCount];
    for (int i = 0 ; i < carCount; i++) {
      res[i] = new Car(cars[i]);
    }
    return res;
  }

  public void resetCars() {
    for (Car car: cars) {
      car.reset();
    }
  }
}
