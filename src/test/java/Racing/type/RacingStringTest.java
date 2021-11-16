package Racing.type;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingStringTest {

  @Test
  @DisplayName("RacingString을 Join할수 있습니다.")
  void testJoining() {
    // given
    Stream<RacingString> racingStringStream = Stream
        .of(RacingString.DISPLAY_TOKEN_STRING,
            RacingString.DISPLAY_TOKEN_STRING,
            RacingString.DISPLAY_TOKEN_STRING,
            RacingString.DISPLAY_TOKEN_STRING,
            RacingString.DISPLAY_TOKEN_STRING,
            RacingString.DISPLAY_TOKEN_STRING);
    // when
    RacingString collect = racingStringStream.collect(RacingString.joining());
    // then
    assertThat(collect.toString()).isEqualTo("------");
  }

  @Test
  @DisplayName("RacingString을 Join할때 Delimiter를 추가할수 있습니다.")
  void testJoiningWithDelimiter() {
    // given
    Stream<RacingString> racingStringStream = Stream
        .of(RacingString.DISPLAY_TOKEN_STRING,
            RacingString.DISPLAY_TOKEN_STRING,
            RacingString.DISPLAY_TOKEN_STRING,
            RacingString.DISPLAY_TOKEN_STRING,
            RacingString.DISPLAY_TOKEN_STRING);
    // when
    RacingString collect = racingStringStream.collect(RacingString.joining(RacingString.DELIMITER));
    // then
    assertThat(collect.toString()).isEqualTo("-\n-\n-\n-\n-");
  }

  @Test
  @DisplayName("RacingString 은 반복할수 있습니다.")
  void repeat() {
    // given
    RacingString racingString = RacingString.DISPLAY_TOKEN_STRING;
    // when
    RacingString collect = racingString.repeat(new RacingNumber(5));
    // then
    assertThat(collect.toString()).isEqualTo("-----");
  }

  @Test
  @DisplayName("RacingString 은 concat할수 있습니다.")
  void concat() {
    // given
    RacingString racingString = RacingString.DISPLAY_TOKEN_STRING;
    // when
    RacingString collect = racingString.concat(RacingString.DELIMITER);
    // then
    assertThat(collect.toString()).isEqualTo("-\n");
  }
}