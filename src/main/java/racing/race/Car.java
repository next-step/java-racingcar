package racing.race;

import racing.strategy.NumberGeneratorStrategy;

public class Car {

  private final String name;
  private int moveDistance;
  private final NumberGeneratorStrategy moveStrategy;

  public Car(String name, NumberGeneratorStrategy numberGeneratorStrategy) {
    this.name = validCarName(name);
    this.moveStrategy = numberGeneratorStrategy;
  }

  void move() {
    int random = moveStrategy.getNumber();
    if (random >= 4) {
      moveDistance++;
    }
  }

  boolean isWinner(int maxDistance) {
    return moveDistance == maxDistance;
  }

  int moveDistance() {
    return moveDistance;
  }

  public String name() {
    return name;
  }

  private String validCarName(String name) {
    if (name.length() > 5) {
      throw new StringIndexOutOfBoundsException();
    }
    return name;
  }

  @Override
  public String toString() {
    return "Car{" +
        "name='" + name + '\'' +
        ", moveDistance=" + moveDistance +
        ", moveStrategy=" + moveStrategy +
        '}';
  }

}
