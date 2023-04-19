package racing.race;

import racing.strategy.NumberGeneratorStrategy;

public class Car {

  private int moveDistance;
  private String name;

  public Car(String name) {
    this.name = name;
  }

  public void move(NumberGeneratorStrategy numberGeneratorStrategy) {
    int random = numberGeneratorStrategy.getNumber();
    if (random >= 4) {
      moveDistance++;
    }
  }

  public int moveDistance() {
    return moveDistance;
  }

}
