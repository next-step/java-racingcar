package step3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Car {
  private int position;

  private Car () {
    this.position = 0;
  }

  public void move () {
    this.position += 1;
  }

  public void move (int n) {
    this.position += n;
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
