package step4;

import java.util.Random;

public class Utils {
  private Utils () {};

  public static int getRandomNumber () {
    return new Random().nextInt(10);
  }
}
