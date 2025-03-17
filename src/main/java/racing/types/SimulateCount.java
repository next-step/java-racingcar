package racing.types;

public class SimulateCount {

  private static final int MIN_SIMULATE_COUNT = 1;

  private final int count;

  public SimulateCount(int simulateCount) {
    if (simulateCount < MIN_SIMULATE_COUNT) {
      throw new IllegalArgumentException("시뮬레이션 횟수는 최소 " + MIN_SIMULATE_COUNT + "회여야 합니다.");
    }
    this.count = simulateCount;
  }

  public int getCount() {
    return count;
  }
}
