/*
 * Description : 자동차경주중 자동차들이 움직이는 기능을 담당
 */

package racingcar;

import java.util.Random;

public class RacingGame {

  private static ResultView resultView;
  private static int RANDOM_BOUND = 10;
  private static int MOVE_MIN_VALUE = 4;

  public static int[] markCarOnTrack(int carCount) {
    return new int[carCount];
  }

  public static void start(int[] carPositionArr, int maxLapCount) {
    for (int i = 0; i < maxLapCount; i++) { //시도수를 하나씩 올려가며
      moveAllCar(carPositionArr);
      System.out.println("");
    }
  }

  private static void moveAllCar(int[] carPositionArr) {
    for (int i = 0; i < carPositionArr.length; i++) { // 차들을 한번씩 랜덤으로 돌림
      move(carPositionArr, i, isMove());
    }
  }

  private static void move(int[] carPositionArr, int targetPosition, boolean isMoved) {
    if (isMoved) {
      carPositionArr[targetPosition] += 1;
    }
    resultView.printCarTrace(carPositionArr, targetPosition);
    System.out.println(""); //차를바꿈
  }

  private static boolean isMove() {
    Random random = new Random();
    int randomValue = random.nextInt(RANDOM_BOUND);
    return randomValue > MOVE_MIN_VALUE;
  }

}