package racing.dto;

public class RacingInput {

  private final int carCount;
  private final int attemptCount;

  public RacingInput(int carCount, int attemptCount) {
    this.carCount = carCount;
    this.attemptCount = attemptCount;
  }

  public int getCarCount() {
    return carCount;
  }

  public int getAttemptCount() {
    return attemptCount;
  }

}
