package racing.object;

public class Car {

  private int distance;

  public void move() {
    addDistance();
  }

  private void addDistance() {
    this.distance++;
  }

  public int getDistance() {
    return distance;
  }

}
