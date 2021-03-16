package racingcar.domain;

public class Car {

  public static final String UNIT = "-";
  public static final int THRESHOLD = 4;

  private Position position;
  private final CarName name;

  private Car(CarName name) {
    this.position = new Position();
    this.name = name;
  }

  public static Car create(CarName name) {
    return new Car(name);
  }

  public static Car create(String name) {
    return new Car(new CarName(name));
  }

  public void move(int randomNumber) {
    if (randomNumber >= THRESHOLD) {
      position = position.move();
    }
  }

  public String showStatus() {
    StringBuilder distanceBuilder = new StringBuilder();

    for (int i = 0; position.biggerThan(i); i++) {
      distanceBuilder.append(UNIT);
    }

    return distanceBuilder.toString();
  }

  public String getName() {
    return name.getName();
  }

  public Position getPosition() {
    return position;
  }

  public boolean isWinner(Position maxPosition) {
    return position.equals(maxPosition);
  }
}
