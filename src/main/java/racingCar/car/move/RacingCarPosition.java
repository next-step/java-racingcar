package racingCar.car.move;

public class RacingCarPosition {

  private int position;

  public RacingCarPosition(int position) {
    this.position = position;
  }

  public int getPosition() {
    return position;
  }

  public RacingCarPosition moveForward () {
    this.position++;
    return this;
  }
}
