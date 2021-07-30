package study.racing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import study.racing.validation.Validation;

class RacingTest {

  @DisplayName("레이싱게임 참가차량수와 시도횟수를 넣고 값이 정상적으로 거리이동이 설정되는지 테스트.")
  @Test
  void 차량수와게임횟수설정테스트() {
    Racing racingWithCarCount = new Racing(3, 1);

    assertThat(racingWithCarCount.getCars()).hasSize(3);
    assertThat(racingWithCarCount.getCars()).extracting(car -> car.getDistance().getMoveDistance())
        .anyMatch(distance -> distance < 2);

    Racing racingWithCarNames = new Racing("test1,test2", 1);

    assertThat(racingWithCarNames.getCars()).hasSize(2);
    assertThat(racingWithCarNames.getCars()).extracting(car2 -> car2.getDistance().getMoveDistance())
        .anyMatch(distance2 -> distance2 < 2);
  }

  @DisplayName("입력값이 null이거나 빈값인 경우 검증하여 IllegalArgumentException이 발생하는지 테스트.")
  @ParameterizedTest
  @NullSource
  void inputValueCheckTest(Integer count) {
    assertThrows(IllegalArgumentException.class,
        () -> {
          Validation.checkValue(count);
        });
  }

}