package step3.domain;

public class Distance {

  private int distance;

  public Distance(int distance) {
    valid(distance);
    this.distance = distance;
  }

  public int get() {
    return this.distance;
  }

  public void move() {
    this.distance++;
  }

  private void valid(int distance) {
    if (distance < 0) {
      throw new IllegalArgumentException();
    }
  }
}
