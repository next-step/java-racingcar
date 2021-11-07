package carracing.domain;

import carracing.ui.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarRacingServiceTest {

  private CarRacingService carRacingService;

  @BeforeEach
  void init() {
    carRacingService = new CarRacingService(new ResultView());
  }

  @ParameterizedTest
  @CsvSource(value = {"5,5", "10,10", "3,7", "9,11"}, delimiter = ',')
  @DisplayName("racing을 위한 차의 대수와 시도 횟수가 정확히 입력시 throw가 발생하지 않는다.")
  void doRacingTestWithNoException(int count, int step) {
    assertDoesNotThrow(() -> carRacingService.doRacing(count, step));
  }

  @ParameterizedTest
  @CsvSource(value = {"-5,5", "-10,10", "-3,7", "-9,11"}, delimiter = ',')
  @DisplayName("racing을 위한 차의 대수가 음수가 입력됐을 때 IllegalArgumentException이 발생한다.")
  void doRacingTestWrongInputCarCount(int count, int step) {
    assertThatIllegalArgumentException().isThrownBy(() -> carRacingService.doRacing(count, step));
  }

  @ParameterizedTest
  @CsvSource(value = {"5,-5", "10,-10", "3,-7", "9,-11"}, delimiter = ',')
  @DisplayName("racing을 위한 도전 기회가 음수가 입력됐을 때 IllegalArgumentException이 발생한다.")
  void doRacingTestWrongInputTryCount(int count, int step) {
    assertThatIllegalArgumentException().isThrownBy(() -> carRacingService.doRacing(count, step));
  }
}