package study.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.error.InvalidCarNameException;

public class NameTest {

  @DisplayName("null이거나 blank한 이름은 생성할 수 없다.")
  @Test
  public void name_ThrowException_NameIsBlank() {
    assertThatThrownBy(() -> new Name(null)).isInstanceOf(InvalidCarNameException.class);
    assertThatThrownBy(() -> new Name("")).isInstanceOf(InvalidCarNameException.class);
    assertThatThrownBy(() -> new Name(" ")).isInstanceOf(InvalidCarNameException.class);
  }

  @DisplayName("길이가 5자를 초과하는 이름은 생성할 수 없다.")
  @Test
  public void name_ThrowException_NameLength5초과() {
    assertThatThrownBy(() -> new Car("123456")).isInstanceOf(InvalidCarNameException.class);
    assertThatThrownBy(() -> new Car("123 45")).isInstanceOf(InvalidCarNameException.class);
  }

  @DisplayName("길이가 5자 이하인 이름을 생성한다.")
  @Test
  public void name_Name_NameLength5이하() {
    Name name = new Name("다섯자에요");
    assertThat(name.getName()).isEqualTo("다섯자에요");
    assertThat(name.getName().length()).isEqualTo(5);
  }

}
