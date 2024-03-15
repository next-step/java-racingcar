package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class LocationTest {
  @Test
  void 입력이_참이면_앞으로_이동() {
    Location location = new Location(0);
    location.forwardConditionally(true);
    assertThat(location).isEqualTo(new Location(1));
  }

  @Test
  void 입력이_거짓이면_이동_안함() {
    Location location = new Location(0);
    location.forwardConditionally(false);
    assertThat(location).isEqualTo(new Location(0));
  }

  @ParameterizedTest
  @CsvSource(value = { "0:''", "1:-", "5:-----"}, delimiter = ':')
  void 입력받은_문자열을_location_만큼_붙여서_반환(int input, String expected) {
    Location location = new Location(input);
    assertThat(location.multiply("-")).isEqualTo(expected);
  }

  @Test
  void 입력보다_더_멀면_참() {
    assertThat(new Location(5).furtherThan(new Location(3)));
  }

  @Test
  void 입력보다_더_가까우면_참() {
    assertThat(new Location(3).closerThan(new Location(5)));
  }
}
