package step3;

public class RacingGameUtils {
  private RacingGameUtils() {}

  public static boolean isCanMove(int randomNumber) {
    if (4 <= randomNumber) {
      return true;
    }
    return false;
  }

  public static int getRandomNumber() {
    return (int) Math.random() * 10;
  }
}
