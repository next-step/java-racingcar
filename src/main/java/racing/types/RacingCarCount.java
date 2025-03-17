package racing.types;

public class RacingCarCount {

  private static final int MIN_CAR_COUNT = 2;

  private final int count;

  public RacingCarCount(int carCount) {
    if (carCount < MIN_CAR_COUNT) {
      throw new IllegalArgumentException("자동차 수는 최소 " + MIN_CAR_COUNT + "대여야 합니다.");
    }
    this.count = carCount;
  }
  
  public int getCount() {
    return count;
  }
}
