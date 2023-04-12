package study.domain.racingGame;

import java.util.Random;

public class CarCondition {
  
  private Random random;
  
  public CarCondition() {
    random = new Random();
  }
  
  public boolean isMove(int num) {
    return num >= 4 && num < 10;
  }
  public boolean isMove() {
    random.setSeed(System.currentTimeMillis() + this.hashCode());
    return isMove(random.nextInt(9));
  }

}
