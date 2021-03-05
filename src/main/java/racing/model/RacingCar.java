package racing.model;

public class RacingCar {

  private int position;

  public RacingCar(int position) {
    this.position = position;
  }

  public void move(int moveCount) {
    this.position += moveCount;
  }

  public int getPosition() {
    return this.position;
  }

}
