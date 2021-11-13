package carracing.domain;

import carracing.domain.entity.Number;
import carracing.domain.entity.Round;
import carracing.domain.service.RandomFourStepRacingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RandomFourStepRacingServiceTest {

  @ParameterizedTest
  @NullSource
  @DisplayName("service 생성시 파라미터로 null이 입력되면 Exception을 던진다.")
  void constructTest(Number input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new RandomFourStepRacingService(input, new Round(input)));
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 3, 10})
  @DisplayName("service 생성시 입력된 number를 통해 number 갯수의 car가 생성되었는지 확인한다.")
  void initTest(int input) {
    RandomFourStepRacingService carRacingService = new RandomFourStepRacingService(new Number(input), new Round(new Number(input)));
    assertThat(carRacingService.getChallengers().getChallengers().size()).isEqualTo(input);
  }

}