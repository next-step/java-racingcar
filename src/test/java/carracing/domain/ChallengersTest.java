package carracing.domain;

import carracing.domain.entity.Challengers;
import carracing.domain.entity.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ChallengersTest {

  @ParameterizedTest
  @NullSource
  @DisplayName("생성자를 통해 참가자들의 전체 숫자를 입력 받을 시 null 입력되면 Exception을 던진다.")
  void constructTest(Number number) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Challengers(number));
  }

}