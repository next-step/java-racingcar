package racing.race;

import racing.strategy.NumberGeneratorStrategy;

public class Car {

  private int moveDistance;

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
