package racing.domain;

public class RacingCar {

  private int carNumber;
  private int position;

  private RacingCar() {

  }

  private RacingCar(int carNumber, int position) {
    this.carNumber = carNumber;
    this.position = position;
  }

  public static RacingCar createNew(int carNumber) {
    return new RacingCar(carNumber, 0);
  }

  public static RacingCar copy(RacingCar racingCar) {
    return new RacingCar(racingCar.getCarNumber(), racingCar.getPosition());
  }

  public int getCarNumber() {
    return this.carNumber;
  }

  public int getPosition() {
    return position;
  }

  public void move() {
    this.position++;
  }
}
