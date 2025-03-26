package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

  @Test
  void createValidName() {
    Name name = new Name("car1");
    assertThat(name.toString()).isEqualTo("car1");
  }

  @ParameterizedTest
  @ValueSource(strings = {"car123456", "verylongname"})
  void invalidateNameLength(String invalidName) {
    assertThatThrownBy(() -> new Name(invalidName))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
  }

  @Test
  @DisplayName("null 값으로 Name 객체 생성 시 예외 발생")
  void createNameWithNull() {
    assertThatThrownBy(() -> new Name(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 null일 수 없습니다.");
  }

  @Test
  @DisplayName("빈 문자열로 Name 객체 생성 시 예외 발생")
  void createNameWithEmptyString() {
    assertThatThrownBy(() -> new Name(""))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 빈 문자열일 수 없습니다.");
  }
} 