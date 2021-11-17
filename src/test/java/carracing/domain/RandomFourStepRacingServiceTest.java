package carracing.domain;

import carracing.domain.entity.Participant;
import carracing.domain.service.RandomFourStepRacingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomFourStepRacingServiceTest {

  @ParameterizedTest
  @CsvSource(value = {"pobbi,scatt,sup:3", "koko,matt:2", "rich,oi,dow,cant,luke:5"}, delimiter = ':')
  @DisplayName("명단 수 만큼 car가 등록되었는지 확인한다.")
  void initTest(String name, int input) {
    RandomFourStepRacingService carRacingService = new RandomFourStepRacingService();
    assertThat(carRacingService.registerRacer(Participant.parse(name)).getChallengers().size()).isEqualTo(input);
  }
}