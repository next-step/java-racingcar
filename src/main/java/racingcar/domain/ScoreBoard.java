package racingcar.domain;

public class ScoreBoard {

  private String name;
  private int carPosition;

  public ScoreBoard(String name, int carPosition) {
    this.name = name;
    this.carPosition = carPosition;
  }

  public String getName() {
    return name;
  }

  public int getCarPosition() {
    return carPosition;
  }
}
