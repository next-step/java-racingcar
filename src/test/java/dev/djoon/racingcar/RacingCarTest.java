package dev.djoon.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import dev.djoon.racingcar.actor.Car;
import dev.djoon.racingcar.actor.OppaCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 자동차경주 테스트 코드
 *
 * - 주어진 횟수만큼 n대의 자동차가 전진하는 기능 구현
 * - 0~9 사이 무작위 값 추출하여, 4 이상인 경우 전진할 수 있는 제약 조건 추가
 * - 자동차의 상태를 화면에 출력하는 기능
 * - 사용자가 조건을 입력할 수 있는 화면 구현
 *
 *   [그 외]
 * + 모든 차는 최대 1칸씩만 이동한다.
 * + 주어진 횟수가 5번이고 3대의 자동차가 전진한다면, 총 이동거리는 15(=5 X 3)이다.
 *
 */
public class RacingCarTest {

  @ParameterizedTest
  @CsvSource(value = {"5:10:50", "1:1:1", "0:0:0", "1:0:0", "0:30:0"}, delimiter = ':')
  @DisplayName("주어진 횟수 k만큼 n대의 자동차가 전진함")
  public void carsMoveLoopTest(final int numberOfCar, final int loopTimes, final int expectedMoveCount) {

    // given
    RacingCarGame racingCarGame = new RacingCarGame();
    for (int i=0; i<numberOfCar; i++) {
      racingCarGame.addCar(new OppaCar());
    }
    racingCarGame.setCondition(Condition.ALWAYS);
    racingCarGame.setLoopTimes(loopTimes);

    // when
    racingCarGame.start();

    // then
    int totalMoveCount = 0;
    for (Car car : racingCarGame.getCarList()) {
      totalMoveCount += car.getXPos();
    }
    assertThat(totalMoveCount).isEqualTo(expectedMoveCount);
  }

  @ParameterizedTest
  @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
  @DisplayName("0~9 사이 값에서 4 이상일 경우 자동차가 전진함")
  public void carMovesByConditionTest(final int condition, final int expectedMoveCount) {

    // given
    RacingCarGame racingCarGame = new RacingCarGame();
    racingCarGame.addCar(new OppaCar());
    racingCarGame.setCondition(condition);
    racingCarGame.setLoopTimes(1);

    // when
    racingCarGame.start();

    // then
    int totalMoveCount = 0;
    for (Car car : racingCarGame.getCarList()) {
      totalMoveCount += car.getXPos();
    }
    assertThat(totalMoveCount).isEqualTo(expectedMoveCount);
  }

  @ParameterizedTest
  @CsvSource(value = {"5:10:28", "1:1:0", "0:0:0", "1:0:0", "0:30:0"}, delimiter = ':')
  @DisplayName("k 횟수만큼 n 대의 자동차가 0~9 사이 값에서 4 이상일 경우 전진함")
  public void carsMoveLoopByConditionTest(final int numberOfCar, final int loopTimes, final int expectedMoveCount) {

    // given
    RacingCarGame racingCarGame = new RacingCarGame();
    for (int i=0; i<numberOfCar; i++) {
      racingCarGame.addCar(new OppaCar());
    }
    racingCarGame.setCondition(Condition.RANDOM_SEED_FIXED_TO_10);
    racingCarGame.setLoopTimes(loopTimes);

    // when
    racingCarGame.start();
    Condition.round = 0;

    // then
    int totalMoveCount = 0;
    for (Car car : racingCarGame.getCarList()) {
      totalMoveCount += car.getXPos();
    }
    assertThat(totalMoveCount).isEqualTo(expectedMoveCount);
  }

}
