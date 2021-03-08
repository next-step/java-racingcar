package dev.djoon.racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import dev.djoon.racingcar.actor.Car;

import dev.djoon.racingcar.actor.OppaCar;
import dev.djoon.racingcar.ui.ResultView;
import dev.djoon.racingcar.util.GameConstant;
import dev.djoon.racingcar.util.RandomNumbers;
import dev.djoon.racingcar.util.TestRandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
  public void carsMoveLoopTest(
      int carQuantity, int loopTimes, int expectedMoveCount) {
    // given
    RacingCarGame racingCarGame = new RacingCarGame(carQuantity, loopTimes);

    // when
    racingCarGame.start(new TestRandomNumbers());

    // then
    int totalMoveCount = 0;
    for (Car car : racingCarGame.getCarList()) {
      totalMoveCount += car.getXPosition();
    }
    assertThat(totalMoveCount).isEqualTo(expectedMoveCount);
  }

  @ParameterizedTest
  @CsvSource(value = {"0:False", "1:False", "2:False", "3:False", "4:True", "5:True", "6:True", "7:True", "8:True", "9:True"}, delimiter = ':')
  @DisplayName("0~9 사이 값에서 4 이상일 경우 자동차가 전진함")
  public void carMovesByConditionTest(int condition, boolean expectedMove) {
    // given
    Car car = new OppaCar();

    // when
    final boolean isCarMoved = car.moveIfValidCondition(condition);

    // then
    assertThat(isCarMoved).isEqualTo(expectedMove);
  }

  @ParameterizedTest
  @CsvSource(value = {"5:10:28", "1:1:0", "0:0:0", "1:0:0", "0:30:0"}, delimiter = ':')
  @DisplayName("k 횟수만큼 n 대의 자동차가 0~9 사이 값에서 4 이상일 경우 전진함")
  public void carsMoveLoopByConditionTest(
      int carQuantity, int loopTimes, int expectedMoveCount) {
    // given
    RacingCarGame racingCarGame = new RacingCarGame(carQuantity, loopTimes);
    RandomNumbers randomNumbers = new RandomNumbers();
    randomNumbers.setSeed(GameConstant.RANDOM_TEST_SEED);

    // when
    racingCarGame.start(randomNumbers);

    // then
    int totalMoveCount = 0;
    for (Car car : racingCarGame.getCarList()) {
      totalMoveCount += car.getXPosition();
    }
    assertThat(totalMoveCount).isEqualTo(expectedMoveCount);
  }

  @ParameterizedTest
  @ValueSource(strings = {"longlo", "longlon", "longlong"})
  @DisplayName("차 이름 길이가 5를 초과할 수 없음.")
  public void carNameLengthTest(String owner) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new OppaCar(owner))
        .withMessageMatching("A owner name cannot be longer than 5 : " + owner);
  }

  @ParameterizedTest
  @CsvSource(value = {"pobi,crong,honux:5"}, delimiter = ':')
  @DisplayName("자동차 경주 완료 후 우승자를 확인한다.")
  public void carNameLengthTest(String ownerNames, int loopTimes) {
    // given
    RacingCarGame racingCarGame = new RacingCarGame(ownerNames.split(","), loopTimes);
    RandomNumbers randomNumbers = new RandomNumbers();
    randomNumbers.setSeed(GameConstant.RANDOM_TEST_SEED);

    // when
    racingCarGame.start(randomNumbers);

    // then
    assertThat(ResultView.winnerNames(racingCarGame.findWinners())).isEqualTo("crong, honux");
  }
}
