package camp.nextstep.racingcar.domain;

public class Position {

  private int position;

  public Position(int position) {
    this.position = position;
  }

  public void moveForward() {
    this.position += 1;
  }

  public int getPosition() {
    return position;
  }
}
