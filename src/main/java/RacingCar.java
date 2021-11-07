public class RacingCar {

  private int progress;

  public RacingCar() {
    this.progress = 0;
  }

  public void move(MoveStrategy moveStrategy) {
    if (moveStrategy.isMovable()) {
      moveForward();
    }
  }

  private void moveForward() {
    progress++;
  }

  public int getProgress() {
    return this.progress;
  }

}
