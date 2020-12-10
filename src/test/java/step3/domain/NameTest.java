package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class NameTest {

  @DisplayName("객체 생성 확인")
  @Test
  void constructorTest() {
    Name name = new Name("name");
    assertThat(name.get()).isEqualTo("name");
  }

  @DisplayName("Car name이 예외 인 경우를 확인")
  @ParameterizedTest
  @ValueSource(strings = {"AAAAAAA", ""})
  void carNameCheckExceptionTest(String carName) {
    assertThatThrownBy(() -> {
      new Name(carName);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
