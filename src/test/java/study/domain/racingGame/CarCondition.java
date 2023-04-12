package study.domain.racingGame;

import java.util.Random;

public class CarCondition {
  private final int MIN_NUM = 4;
  private final int MAX_NUM = 9;
  private Random random;
  
  public CarCondition() {
    random = new Random();
  }
  
  public boolean isMove(int num) {
    return num >= MIN_NUM && num <= MAX_NUM;
  }
  public boolean isMove() {
    return isMove(random.nextInt(9));
  }

}
