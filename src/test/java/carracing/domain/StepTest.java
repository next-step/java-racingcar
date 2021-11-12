package carracing.domain;

import carracing.domain.entity.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StepTest {

  private Step step;

  @BeforeEach
  void setUp() {
    step = new Step();
  }

  @ParameterizedTest
  @ValueSource(ints = {1})
  @DisplayName("step 생성시 1로 초기화 된다.")
  void constructTest(int init) {
    assertThat(step.getValue()).isEqualTo(init);
  }

  @ParameterizedTest
  @CsvSource(value = {"5:6", "10:11", "20:21", "30:31"}, delimiter = ':')
  @DisplayName("plus로 step을 증가시켰을 시 증가한 숫자만큼 step이 증가한다")
  void plusTest(int input, int result) {
    for (int i = 0; i < input; i++) {
      step.plus();
    }
    assertThat(step.getValue()).isEqualTo(result);
  }

}