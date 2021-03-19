package study1.racing.code.moveStrategy;

import java.util.Random;

public class RaceMove implements MoveStrategy {
  @Override
  public boolean move() {
    if(new Random().nextInt(10) > 4) {
      return true;
    }
    return false;
  }
}
