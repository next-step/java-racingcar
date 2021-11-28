package racingCar.model;

public class RacingCar implements Comparable<RacingCar> {

  private Position position;
  private Name name;

  public RacingCar(String name) {
    this(0, name);
  }

  public RacingCar(int position, String name) {
    this.position = new Position(position);
    this.name = new Name(name);
  }

  public void tryMove(int number) {
    position = position.move(number);
  }

  public Name getName() {
    return name;
  }

  public Position getPosition() {
    return position;
  }

  @Override
  public int compareTo(RacingCar other) {
    return position.compareTo(other.position);
  }
}
