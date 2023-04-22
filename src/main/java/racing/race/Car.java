package racing.race;

import racing.strategy.NumberGeneratorStrategy;

public class Car {

  private String name;
  private int moveDistance;
  private NumberGeneratorStrategy moveStrategy;

  public Car(String name, NumberGeneratorStrategy numberGeneratorStrategy) {
    this.name = name;
    this.moveStrategy = numberGeneratorStrategy;
  }

  public void move() {
    int random = moveStrategy.getNumber();
    if (random >= 4) {
      moveDistance++;
    }
  }

  public int moveDistance() {
    return moveDistance;
  }

  public String name() {
    return name;
  }

}
