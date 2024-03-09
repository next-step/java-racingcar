package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import testutils.IOTest;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest extends IOTest {
  @ParameterizedTest
  @CsvSource(value = { "1:1", "5:5" }, delimiter = ':')
  void 자동차_대수_입력(String numberOfCars, int expected) {
    setInputStream(numberOfCars.getBytes());

    assertThat(InputView.getInputNumberOfCars()).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = { "1:1", "5:5" }, delimiter = ':')
  void 이동_횟수_입력(String numberOfReps, int expected) {
    setInputStream(numberOfReps.getBytes());

    assertThat(InputView.getInputNumberOfReps()).isEqualTo(expected);
  }
}
