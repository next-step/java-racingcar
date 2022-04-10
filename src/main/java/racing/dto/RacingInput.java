package racing.dto;

public class RacingInput {

  private int carCount;
  private int attemptCount;

  public RacingInput() {
  }

  public RacingInput(int carCount, int attemptCount) {
    this.carCount = carCount;
    this.attemptCount = attemptCount;
  }

  public int getCarCount() {
    return carCount;
  }

  public void setCarCount(int carCount) {
    this.carCount = carCount;
  }

  public int getAttemptCount() {
    return attemptCount;
  }

  public void setAttemptCount(int attemptCount) {
    this.attemptCount = attemptCount;
  }

}
