package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

  @Test
  @DisplayName("이름 객체 생성")
  void create() {
    // given
    Name name = Name.create("gmoon");

    // when
    String expected = "gmoon";

    // then
    assertThat(name).isEqualTo(Name.create(expected));
  }

  @Test
  @DisplayName("자동차 이름의 자릿수는 5를 초과할 수 없다.")
  void createError() {
    // given

    // when

    // then
    assertThatThrownBy(() -> Name.create("123456"))
            .isInstanceOf(IllegalArgumentException.class);
  }
}
