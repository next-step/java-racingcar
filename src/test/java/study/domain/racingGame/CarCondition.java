package study.domain.racingGame;

public class CarCondition {

  private static final int MIN_NUM = 4;
  private static final int MAX_NUM = 9;

  public CarCondition() {
  }

  public boolean isMove(int num) {
    return num >= MIN_NUM && num <= MAX_NUM;
  }

}
