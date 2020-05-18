package step3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Car {
  private int position;

  private Car () {
    this.position = 0;
  }

  public Car move () {
    this.position += 1;
    return this;
  }

  public Car move (int n) {
    this.position += n;
    return this;
  }

  public String getPositionString () {
    return Arrays.stream(new String[this.position])
                 .map(v -> "-")
                 .collect(Collectors.joining(""));
  }

  public static Car of () {
    return new Car();
  }
}
