public class RacingCarResult {

  private String name;
  private int progress;

  public RacingCarResult(RacingCar racingCar) {
    this.name = racingCar.getName();
    this.progress = racingCar.getProgress();
  }


  public String getName() {
    return name;
  }

  public int getProgress() {
    return progress;
  }
}
