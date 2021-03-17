package racing.domain;

import racing.rule.MoveRule;

public class RacingCar {

  private int carNumber;
  private int position;

  private RacingCar() {

  }

  private RacingCar(int carNumber, int position) {
    this.carNumber = carNumber;
    this.position = position;
  }

  public static RacingCar newCar(int carNumber) {
    return new RacingCar(carNumber, 0);
  }

  public static RacingCar copyCar(RacingCar racingCar) {
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
