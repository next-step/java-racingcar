package racing.domain;

import racing.rule.MoveRule;

public class RacingCar {

  private final int carNumber;
  private int position;

  private RacingCar(int carNumber) {
    this(carNumber, 0);
  }

  private RacingCar(int carNumber, int position) {
    this.carNumber = carNumber;
    this.position = position;
  }

  public static RacingCar create(int carNumber) {
    return new RacingCar(carNumber);
  }

  public static RacingCar copyFrom(RacingCar racingCar) {
    return new RacingCar(racingCar.carNumber(), racingCar.position());
  }

  public int carNumber() {
    return this.carNumber;
  }

  public int position() {
    return position;
  }

  public void move(MoveRule moveRule) {
    if (moveRule.possibleMove()) {
      this.position++;
    }
  }
}
