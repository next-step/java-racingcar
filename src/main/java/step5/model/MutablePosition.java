package step5.model;

// 이렇게도 만들 수 있다.
public class MutablePosition {
  private int position;

  public MutablePosition() {
    this(0);
  }

  public MutablePosition(int position) {
    this.position = position;
  }

  public MutablePosition move() {
    position = position + 1;
    return this;
  }

  public void moveWithoutReturn() {
    position += 1;
  }

  public int getPosition() {
    return position;
  }

}
