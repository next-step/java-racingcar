package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.domain.racingGame.CarCondition;

public class CarConditionTest {

  private CarCondition carCondition;

  @BeforeEach
  void setUp() {
    carCondition = new CarCondition();
  }

  @DisplayName("차가 움직일 수 있는 지 테스트")
  @ParameterizedTest
  @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true",
      "10:false"}, delimiter = ':')
  void isMoveCheckTest(int num, boolean expected) {
    assertThat(carCondition.isMove(num)).isEqualTo(expected);
  }
}
