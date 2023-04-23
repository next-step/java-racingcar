package racingrefactoring.domain;

public class Position {

  private int position;

  protected Position() {
    this.position = 0;
  }

  protected Position(int position) {
    this.position = position;
  }

  public void move() {
    position++;
  }

  public int getPosition() {
    return position;
  }

  public boolean isMax(Position maxPosition) {
    return maxPosition.isSamePosition(position);
  }

  private boolean isSamePosition(int position) {
    return this.position == position;
  }
}
