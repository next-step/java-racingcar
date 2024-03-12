package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {
  @ParameterizedTest
  @ValueSource(strings = { "javajigi", "oht1221" })
  void 길이가_5_초과인_이름의_객체_생성_불가(String input) {
    assertThatThrownBy(() -> new CarName(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Car name longer than 5 not allowed.");
  }

  @ParameterizedTest
  @ValueSource(strings = { "Jenny", "Dan" })
  void 길이가_5_이하인_이름의_객체_생성_가능(String input) {
    assertThat(new CarName(input)).isInstanceOf(CarName.class);
  }
}
