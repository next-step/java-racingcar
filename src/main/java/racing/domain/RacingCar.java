package racing.domain;

public class RacingCar {

  private String name;

  private String position;

  private RacingCar() {

  }

  private RacingCar(String name, String position) {
    this.name = name;
    this.position = position;
  }

  public static RacingCar createNew(int line) {
    return new RacingCar("player " + line, "");
  }
  public static RacingCar copy(RacingCar racingCar) {
    return new RacingCar(racingCar.getName(), racingCar.getPosition());
  }

  public String getName() {
    return name;
  }

  public String getPosition() {
    return position;
  }

  public void move() {
    this.position += "=";
  }
}
