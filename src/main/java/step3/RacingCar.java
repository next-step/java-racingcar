package step3;

public class RacingCar extends Car {

  /**
   * 0~9 사이의 수를 무작위로 생성 후 값에 따라 이동.
   * 
   * 무작위 수가 4 이상일 경우 distance ++
   */
  @Override
  public void move() {
    moveRacingCarByNumber(RacingGameUtils.getRandomNumber());
  }
  
  /**
   * 입력받은 수가 4 이상일 경우 자동차의 distance ++
   * @param randomNumber : int : 무작위 수
   */
  public void moveRacingCarByNumber(int number) {
    if (RacingGameUtils.isCanMove(number)) {
      super.move();
    }
  }
}
