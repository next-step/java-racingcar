package racingrefactoring.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameTest {

  @Test
  void 이름이_5글자를_초과하는_경우(){
    assertThatThrownBy(() -> new Name("123456"))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("이름은 5자 이하만 가능합니다.");
  }


}