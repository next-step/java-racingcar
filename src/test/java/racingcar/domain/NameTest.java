package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

  @Test
  void createName() {
    Name name = new Name("pobi");
    assertThat(name).isNotNull();
  }

  @Test
  void nameLengthValidate() {
    assertThatThrownBy(() -> {
      new Name("pobipobipobi");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void nameIsNotNull() {
    assertThatThrownBy(() -> {
      new Name(null);
    }).isInstanceOf(IllegalArgumentException.class);
  }

}