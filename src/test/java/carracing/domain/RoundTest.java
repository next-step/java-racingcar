package carracing.domain;

import carracing.domain.entity.Number;
import carracing.domain.entity.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RoundTest {

  private Round round;

  @BeforeEach
  void setUp() {
    round = new Round(new Number(10));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 5, 7, 10})
  @DisplayName("round 생성시 입력 파라미터 값 대로 생성이 이루어졌는지 확인한다.")
  void constructTest(int input) {
    Round round = new Round(new Number(input));
    assertThat(round.getRound()).isEqualTo(input);
  }

  @ParameterizedTest
  @NullSource
  @DisplayName("Round 생성 시 null이 입력되면 Exception을 던진다.")
  void constructInputNullTestWithException(Number input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Round(input));
  }

  @ParameterizedTest
  @ValueSource(ints = 0)
  @DisplayName("Round 생성 시 null이 입력되면 Exception을 던진다.")
  void constructInputZeroTestWithException(int input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Round(new Number(input)));
  }

  @ParameterizedTest
  @CsvSource(value = {"3:7", "5:5", "6:4", "10:0"}, delimiter = ':')
  @DisplayName("minus()를 이용해 round 횟수를 하나씩 감소시킬때 감소가 정확하게 이루어진다.")
  void minusTest(int count, int remain) {
    for(int i = 0; i < count; i++) {
      round.minus();
    }
    assertThat(round.getRound()).isEqualTo(remain);
  }

  @ParameterizedTest
  @CsvSource(value = {"11:0", "200:0", "16:0", "20:0"}, delimiter = ':')
  @DisplayName("minus()를 이용해 round 횟수를 하나씩 감소시킬때 횟수가 모두 소진되면 감소가 일어나지 않고 0이 된다.")
  void tooMuchMinusTest(int count, int remain) {
    for(int i = 0; i < count; i++) {
      round.minus();
    }
    assertThat(round.getRound()).isEqualTo(remain);
  }

  @ParameterizedTest
  @CsvSource(value = {"5:true", "10:false", "3:true", "20:false"}, delimiter = ':')
  @DisplayName("round 횟수가 남아있는지(0보다 큰지) 확인한다. 남았다면 true를 남아있지 않다면 false를 반한한다.")
  void hasMoreChanceTest(int count, boolean isPossible) {
    for(int i = 0; i < count; i++) {
      round.minus();
    }
    assertThat(round.hasMoreChance()).isEqualTo(isPossible);
  }

}