package racingcar;

import java.util.Objects;

public class Location {
  private int location;

  public Location(final int location) {
    this.location = location;
  }

  public void forwardConditionally(boolean meet) {
    if (meet) {
      this.location++;
    }
  }

  public boolean furtherThan(Location target) {
    return this.location > target.location;
  }

  public boolean closerThan(Location target) {
    return this.location < target.location;
  }

  public String multiply(String distanceUnit) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < this.location; i++) {
      sb.append(distanceUnit);
    }

    return sb.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Location) {
      return this.location == ((Location) obj).location;
    }

    if (obj instanceof Integer) {
      return this.location == ((Integer) obj);
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.location);
  }

  @Override
  public String toString() {
    return String.valueOf(this.location);
  }
}
