package carracing.domain;

import carracing.domain.dto.RacingData;
import carracing.domain.entity.Car;
import carracing.domain.entity.Challengers;
import carracing.domain.entity.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ChallengersTest {

  private static final int size = 3;

  private Challengers challengers;

  @BeforeEach
  void setUp() {
    challengers = new Challengers(new Number(size));
    for (int i = 0; i < size; i++) {
      challengers.register(new Car());
    }
  }

  @ParameterizedTest
  @NullSource
  @DisplayName("생성자를 통해 참가자들의 전체 숫자를 입력 받을 시 null 입력되면 Exception을 던진다.")
  void constructTest(Number number) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Challengers(number));
  }

  @ParameterizedTest
  @CsvSource(value = {"1:1", "4:2", "10:2"}, delimiter = ':')
  void startRoundTest(int input, int result) {
    for (RacingData racingData : challengers.startRound(isMoved(input)).getRacingDataList()) {
        assertThat(racingData.getStep()).isEqualTo(result);
    }
  }

  Supplier<Boolean> isMoved(int a) {
    return () -> a > 3;
  }

}