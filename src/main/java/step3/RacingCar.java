package step3;

public class RacingCar extends Car {
  @Override
  public void move() {
    moveRacingCarByRandomNumber(RacingGameUtils.getRandomNumber());
  }

  public void moveRacingCarByRandomNumber(int randomNumber) {
    if (RacingGameUtils.isCanMove(randomNumber)) {
      super.move();
    }
  }
}
