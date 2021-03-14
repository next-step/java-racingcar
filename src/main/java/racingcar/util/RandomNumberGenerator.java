package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
  private static final int RANDOM_NUMBER_BOUND = 10;
  private final Random seed;

  public RandomNumberGenerator(long currentTimeSeed) {
    this.seed = new Random(currentTimeSeed);
  }

  public int generateRandomNumber() {
    return seed.nextInt(RANDOM_NUMBER_BOUND);
  }
<<<<<<< HEAD
=======
    private static final int RANDOM_NUMBER_BOUND = 10;
    private final Random seed;

    public RandomNumberGenerator(long currentTimeSeed) {
      this.seed = new Random(currentTimeSeed);
    }

    public int generateRandomNumber() {
      return seed.nextInt(RANDOM_NUMBER_BOUND);
    }
>>>>>>> 5a4cea0c (fix : rebase 하면서 누락된 파일 추가)
=======
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
}
