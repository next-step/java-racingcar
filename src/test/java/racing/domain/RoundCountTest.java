package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.exception.RacingException;

class RoundCountTest {

  private final int CNT = 10;
  private RoundCount count;

  @BeforeEach
  void init() {
    count = new RoundCount(CNT);
  }

  @ParameterizedTest
  @CsvSource({"1,true"})
  void canRaceCheckMoreThan0(int cnt, boolean expected) {
    count = new RoundCount(cnt);
    assertThat(count.canRace()).isEqualTo(expected);
  }

  @Test
  void doRaceDecreaseCount() {
    count.doRace();
    assertThat(count).isEqualTo(new RoundCount(CNT - 1));
  }

  @ParameterizedTest
  @CsvSource({"10,true", "1,false", "5,false"})
  void equalsCheck(int cnt, boolean expected) {
    RoundCount compared = new RoundCount(cnt);
    assertThat(compared.equals(count)).isEqualTo(expected);
  }

  @Test
  void throwsException() {
    assertThatThrownBy(() -> new RoundCount(0))
        .isInstanceOf(RacingException.class)
        .hasMessageContaining("1번 이상");
  }
}