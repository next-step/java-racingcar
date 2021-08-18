package step45.domain;

import java.util.Objects;

public class Location {

  private final int location;

  public Location(int location) {
    checkLocation(location);
    this.location = location;
  }

  public Location increase(int distance) {
    return new Location(this.location + distance);
  }

  public int getLocation() {
    return location;
  }

  private void checkLocation(int location) {
    if (location < 0) {
      throw new IllegalArgumentException("위치값은 음수가 될 수 없습니다.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location1 = (Location) o;
    return location == location1.location;
  }

  @Override
  public int hashCode() {
    return Objects.hash(location);
  }
}
