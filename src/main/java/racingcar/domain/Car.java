package racingcar.domain;

public class Car {

  private int position;
  private String name;

  private Car(String name) {
    this.position = 0;
    this.name = name;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }

  protected int updatePosition(int random) {
    if (random >= 4) {
      this.position = this.position + 1;
    }
    return this.position;
  }

  public static Car create(String name) {
    return new Car(name);
  }
}
