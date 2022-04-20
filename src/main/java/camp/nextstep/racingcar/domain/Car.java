package camp.nextstep.racingcar.domain;

public class Car {

  private int position;

  public Car() {
    this.position = 0;
  }

  public void move(MoveCondition condition) {
    if (!condition.isSatisfied()) {
      return;
    }
    this.position++;
  }

  public int getPosition() {
    return position;
  }
}
