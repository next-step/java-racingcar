package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
