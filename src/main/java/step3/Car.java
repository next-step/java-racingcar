package step3;

import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
  private int move;
  private static final int BOUND = 9;

  public void setMove() {
    if (new Random().nextInt(BOUND) >= 4) {
      this.move++;
    }
  }

  @Override
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < move; i++) {
      buffer.append("-");
    }
    return buffer.toString();
  }
}
