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

  public int updatePosition(int random) {
    int UPDATE_POSITION_THRESHOLD = 4;
    if (random >= UPDATE_POSITION_THRESHOLD) {
      this.position = this.position + 1;
    }
    return this.position;
  }

  public static Car create(String name) {
    return new Car(name);
  }
}
