package step3;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
  private int move;
  private static final int BOUND = 9;

  public void setMove() {
    if (new Random().nextInt(BOUND) >= 4) {
      this.move += 1;
    }
  }

  @Override
  public String toString() {
    return IntStream.range(0, move)
            .mapToObj(i -> "-")
            .collect(Collectors.joining("", "-", ""));
  }
}
