package racing.simulator;


public class CarRacingGameSimulator {

  private static final int MIN_CAR_COUNT = 2;
  private static final int MIN_SIMULATE_COUNT = 1;

  private final int carCount;
  private final int simulateCount;
  private final CarMoveDecider carMoveDecider;
  private final Car[] cars;

  CarRacingGameSimulator(int carCount, int simulateCount, CarMoveDecider carMoveDecider) {
    if (isNotValidCarCount(carCount)) {
      throw new IllegalArgumentException("자동차 수는 최소 " + MIN_CAR_COUNT + "대여야 합니다.");
    }

    if (isNotValidSimulateCount(simulateCount)) {
      throw new IllegalArgumentException("시뮬레이션 횟수는 최소 " + MIN_SIMULATE_COUNT + "회여야 합니다.");
    }

    this.carCount = carCount;
    this.simulateCount = simulateCount;
    this.carMoveDecider = carMoveDecider;
    this.cars = new Car[carCount];
    for (int i = 0; i < carCount; i++) {
      cars[i] = new Car();
    }
  }

  static boolean isNotValidCarCount(int carCount) {
    return carCount < MIN_CAR_COUNT;
  }

  static boolean isNotValidSimulateCount(int simulateCount) {
    return simulateCount < MIN_SIMULATE_COUNT;
  }

  Car[] simulate() {
    for (int i = 0; i < simulateCount; i++) {
      moveCars();
    }

    Car[] res = copyCars();

    resetCars();

    return res;
  }

  void moveCars() {
    for (Car car: cars) {
      if (this.carMoveDecider.canMove()) {
        car.go();
      }
    }
  }

  Car[] copyCars() {
    Car[] res = new Car[carCount];
    for (int i = 0 ; i < carCount; i++) {
      res[i] = new Car(cars[i]);
    }
    return res;
  }

  void resetCars() {
    for (Car car: cars) {
      car.reset();
    }
  }
}
