package carracing.domain;

import carracing.domain.entity.Number;
import carracing.domain.entity.Participant;
import carracing.domain.entity.Round;
import carracing.domain.service.RandomFourStepRacingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RandomFourStepRacingServiceTest {

  @ParameterizedTest
  @NullSource
  @DisplayName("service 생성시 파라미터로 null이 입력되면 Exception을 던진다.")
  void constructTest(Number input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new RandomFourStepRacingService(null, new Round(input)));
  }

  @ParameterizedTest
  @CsvSource(value = {"pobbi,scatt,sup:3", "koko,matt:2", "rich,oi,dow,cant,luke:5"}, delimiter = ':')
  @DisplayName("service 생성시 입력된 이름를 통해 이름이 갯수만큼 car가 생성되었는지 확인한다.")
  void initTest(String name, int input) {
    RandomFourStepRacingService carRacingService = new RandomFourStepRacingService(Participant.of(name), new Round(new Number(input)));
    assertThat(carRacingService.getChallengers().getChallengers().size()).isEqualTo(input);
  }

}