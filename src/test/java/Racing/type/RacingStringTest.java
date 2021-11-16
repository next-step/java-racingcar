package Racing.type;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class RacingStringTest {

  @Test
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
  void repeat() {
    // given
    RacingString racingString = RacingString.DISPLAY_TOKEN_STRING;
    // when
    RacingString collect = racingString.repeat(new RacingNumber(5));
    // then
    assertThat(collect.toString()).isEqualTo("-----");
  }

  @Test
  void concat() {
    // given
    RacingString racingString = RacingString.DISPLAY_TOKEN_STRING;
    // when
    RacingString collect = racingString.concat(RacingString.DELIMITER);
    // then
    assertThat(collect.toString()).isEqualTo("-\n");
  }
}