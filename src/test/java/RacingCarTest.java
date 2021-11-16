import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

  @Test
  @DisplayName("move 전략 리턴값이 true일 때 RacingCar가 항상 전진하는지 검증하기 위한 테스트")
  void move() {
    // given
    RacingCar racingCar = createRacingCarForTest();
    int expectedProgress = 1;

    // when
    racingCar.move(() -> true);

    // then
    assertThat(racingCar.getProgress()).isEqualTo(expectedProgress);
  }

  private RacingCar createRacingCarForTest() {
    String name = "car";
    return new RacingCar(name);
  }

  @Test
  @DisplayName("move 전략 리턴값이 false일 때 RacingCar의 progress값에 1이 더해지지 않고 초기값 0을 가지는지 검증하기 위한 테스트")
  void dontMove() {
    // given
    RacingCar racingCar = createRacingCarForTest();
    int expectedProgress = 0;

    // when
    racingCar.move(() -> false);

    // then
    assertThat(racingCar.getProgress()).isEqualTo(expectedProgress);
  }

  @ParameterizedTest
  @CsvSource(value = {"c, 1", "car, 3", "carname, 5", "carnameis, 5"})
  @DisplayName("RacingCar의 이름의 길이가 항상 최대값 이하인지 검증하기 위한 테스트")
  void lengthOfRacingCarNameAlwaysLowerThanLimit(String carName, int expectedLength) {
    // when
    RacingCar racingCar = new RacingCar(carName);

    // then
    assertThat(racingCar.getName().length()).isEqualTo(expectedLength);
  }

  @Test
  @DisplayName("RacingCar의 이름에 null이 들어오는 경우 DEFAULT_NAME으로 설정되는지 검증하기 위한 테스트")
  void useDefaultNameWhenRacingCarNameIsNull() {
    RacingCar racingCar = new RacingCar(null);
    assertThat(racingCar.getName().length()).isEqualTo(0);
    assertThat(racingCar.getName()).isEqualTo(RacingCar.DEFAULT_NAME);
  }

}
