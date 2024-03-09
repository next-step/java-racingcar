package step3;

public class Car {
  private int location = 0;

  public Car() {
  }

  public Car(int location) {
    this.location = location;
  }
  public void moveConditionally(int condition) {
    final int CRITERIA = 4;
    if (condition >= CRITERIA) {
      this.location++;
    }
  }

  public int getLocation() {
    return this.location;
  }
}
