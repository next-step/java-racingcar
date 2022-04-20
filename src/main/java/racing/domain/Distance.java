package racing.domain;

import racing.exception.NegativeDistanceException;

public class Distance {

  private int distance;

  public Distance() {
    this(0);
  }

  public Distance(int distance) {
    if (distance < 0) {
      throw new NegativeDistanceException();
    }
    this.distance = distance;
  }

  public void increase() {
    this.distance = distance + 1;
  }

  public Distance getLarger(Distance compareDistance) {
    if (this.distance > compareDistance.distance) {
      return this;
    }
    return compareDistance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Distance distance1 = (Distance) o;
    return distance == distance1.distance;
  }

  public int getAmount() {
    return this.distance;
  }
}
