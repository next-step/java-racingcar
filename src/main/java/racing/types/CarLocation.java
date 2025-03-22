package racing.types;

import java.util.Objects;

public class CarLocation implements Comparable<CarLocation> {

  private final int location;

  public CarLocation () {
    this.location = 0;
  }

  public CarLocation(int location) {
    this.location = location;
  }

  public CarLocation(CarLocation carLocation) {
    this.location = carLocation.location;
  }

  public CarLocation getNextLocation() {
    return new CarLocation(this.location + 1);
  }

  @Override
  public int compareTo(CarLocation carLocation) {
    return Integer.compare(this.location, carLocation.location);
  }

  @Override
  public String toString() {
    return "-".repeat(Math.max(0, location));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CarLocation that = (CarLocation) o;
    return location == that.location;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(location);
  }
}
