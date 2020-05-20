package step4;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Car {
  private final String name;
  private int position = 0;

  private Car (final String name) {
    this.name = name;
  }

  public Car move (MoveStrategy strategy) {
    if (strategy.isMoved())
      this.position += 1;
    return this;
  }

  public Car move (int n) {
    this.position += n;
    return this;
  }

  public int getPosition () {
    return this.position;
  }

  public String getName () {
    return this.name;
  }

  public String getPositionString () {
    return String.join(" : ",
      this.name,
      Arrays.stream(new String[this.position])
            .map(v -> "-")
            .collect(Collectors.joining(""))
    );
  }

  public static Car of (String name) {
    return new Car(name);
  }

  public static Car of () {
    return new Car("Car");
  }
}
