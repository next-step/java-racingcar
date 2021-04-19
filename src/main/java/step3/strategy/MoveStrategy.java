package step3.strategy;

import java.util.Random;

public class MoveStrategy {

  public boolean isMove() {
    if (new Random().nextInt(10) >=4) {
      return true;
    }
    return false;
  }

}
