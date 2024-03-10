package step3;

public class Car {
  private int location = 0;

  public Car() {
  }

  public Car(int location) {
    this.location = location;
  }
  public void moveConditionally(final int condition) {
    if (meetMoveCondition(condition)) {
      this.location++;
    }
  }

  private boolean meetMoveCondition(final int condition) {
    final int CRITERIA = 4;
    return condition >= CRITERIA;
  }

  public boolean isLocationValueOf(final int location) {
    return this.location == location;
  }

  public String trace() {
    final String UNIT_GRAPHIC = "-";
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < this.location; i++) {
      sb.append(UNIT_GRAPHIC);
    }

    return sb.toString();
  }
}
