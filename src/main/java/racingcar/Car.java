package racingcar;

public class Car {

  public static final String UNIT = "-";
  private int distance;

  public boolean move(int randomNumber) {
    if (randomNumber >= 4) {
      distance += 1;
      return true;
    }
    return false;
  }

  public String showStatus() {
    StringBuilder distanceBuilder = new StringBuilder();

    for (int i = 0; i < distance; i++) {
      distanceBuilder.append(UNIT);
    }

    return distanceBuilder.toString();
  }
}
