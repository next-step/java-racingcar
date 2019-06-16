package racingcar.mocks;

import racingcar.util.RandomUtil;

/**
 *
 * Car 객체의 move() 메소드 테스트를 위한 Mock 객체
 * move() 메소드는 random함수를 통해 4 이상의 int를 받을때에만 position += 1
 */
public class MockRandomUtil extends RandomUtil {

  @Override
  public int nextInt() {
    return 10;
  }
}
