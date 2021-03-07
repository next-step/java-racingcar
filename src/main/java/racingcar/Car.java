package racingcar;

public class Car {

  public static final String UNIT = "-";
  public static final int THRESHOLD = 4;

  private int distance;
  private final String name;

  public Car(String name) {
    this.name = name;
  }

  public void move(int randomNumber) {
    if (randomNumber >= THRESHOLD) {
      distance += 1;
    }
  }

  public String showStatus() {
    StringBuilder distanceBuilder = new StringBuilder();

    for (int i = 0; i < distance; i++) {
      distanceBuilder.append(UNIT);
    }

    return distanceBuilder.toString();
  }

  public String getName() {
    return name;
  }
}
