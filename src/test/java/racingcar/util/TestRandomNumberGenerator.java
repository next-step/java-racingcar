package racingcar.util;

public class TestRandomNumberGenerator extends RandomNumberGenerator {
    public TestRandomNumberGenerator(long currentTimeSeed) {
      super(currentTimeSeed);
    }

    @Override
    public int generateRandomNumber() {
      return 5;
    }
}
