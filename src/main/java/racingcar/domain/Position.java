package racingcar.domain;

import java.util.Objects;

public class Position {

  private int position;

  public Position(int position) {
    validation(position);
    this.position = position;
  }

  private void validation(int position) {
    if(position < 0) {
      throw new IllegalArgumentException("ERROR : 음수는 허용되지 않습니다.");
    }
  }

  public void forwardPosition() {
    position = position + 1;
  }

  public int toInt() {
    return position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Position)) {
      return false;
    }
    Position position1 = (Position) o;
    return position == position1.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }

}

