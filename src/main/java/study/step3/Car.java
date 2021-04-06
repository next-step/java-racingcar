package study.step3;

import org.apache.commons.lang3.StringUtils;

public class Car {

  private int position;

  private String path;

  public Car() {};

  public Car(int position) {
    this.position = position;
  }

  public int curPosition() {
    return position;
  }

  public String curPath() {
    return this.path;
  }

  public void move(int position) {
    if (isMove(position)) {
      this.position = position;
      makePath(position);
    }
  }

  public boolean isMove(int randomPosition) {
    if (randomPosition > 3) {
      return true;
    }

    return false;
  }

  public void makePath(int position) {
    this.path = StringUtils.isEmpty(this.path) ? "" : this.path;

    for (int i = 0; i < position; i++) {
      this.path = path + "-";
    }
  }

}
