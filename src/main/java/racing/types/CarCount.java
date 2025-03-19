package racing.types;

public class CarCount {

  public static final int MIN_CAR_COUNT = 2;

  private final int count;

  public static CarCount valueOf(int carCount) {
    return new CarCount(carCount);
  }

  private CarCount(int carCount) {
    if (carCount < MIN_CAR_COUNT) {
      throw new IllegalArgumentException("자동차 수는 최소 " + MIN_CAR_COUNT + "대여야 합니다.");
    }
    this.count = carCount;
  }

  public int getCount() {
    return count;
  }
}
