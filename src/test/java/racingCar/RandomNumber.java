package racingCar;

import java.util.Random;

/**
 * @author choijaeyong on 2021/03/08.
 * @project java-racingcar
 * @description
 */
public class RandomNumber {

  public static int create() {
    Random random = new Random();
    return random.nextInt(10);
  }

}
