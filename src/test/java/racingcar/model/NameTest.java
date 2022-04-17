package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

  @ParameterizedTest(name = "생성 시, 이름이 1자 이상 5자 이하가 아니라면 예외를 던진다")
  @ValueSource(strings = {"", "가나다라마바"})
  void create(String value) {
    assertThatThrownBy(() -> new Name(value)).isInstanceOf(IllegalArgumentException.class);
  }
}
