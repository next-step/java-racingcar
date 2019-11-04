package step3.racingcarWinner;

import java.util.Random;

public class RacingGame {

  private static String inputName;
  private static int inputTryCount;

  private static final int RANDOM_BOUND = 10;
  private static final int MOVE_MIN_VALUE = 4;

  public RacingGame(String inputName, int inputTryCount) {
    this.inputName = inputName;
    this.inputTryCount = inputTryCount;
  }

  public String[] carNameArr(String inputName) {
    return inputName.split(",");
  }


  public boolean isMove(int arg) {
    if (arg >= MOVE_MIN_VALUE) {
      return true;
    }
    return false;
  }

  private int getRandomNo() {
    Random random = new Random();
    return random.nextInt(RANDOM_BOUND);
  }
}
