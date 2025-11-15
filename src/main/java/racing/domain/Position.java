package racing.domain;

import racing.exception.ErrorMessage;
import racing.exception.RacingException;

public class Position implements Comparable<Position> {

  private int position;

  public Position(int position) {
    if (position < 0) {
      throw new RacingException(PositionMessage.INVALID_CAR_INIT_POSITION);
    }
    this.position = position;
  }

  public void move(int dist) {
    this.position += dist;
  }

  public int getPosition() {
    return position;
  }

  @Override
  public int compareTo(Position o) {
    return this.position - o.position;
  }

  enum PositionMessage implements ErrorMessage {
    INVALID_CAR_INIT_POSITION("자동차의 위치는 0부터 시작합니다");

    private String message;

    PositionMessage(String message) {
      this.message = message;
    }

    public String getMessage() {
      return message;
    }
  }
}
