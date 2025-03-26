package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class NamesTest {

  @Test
  void getNamesByIndex() {
    Names names = new Names(new String[]{"car1", "car2", "car3"});
    assertThat(names.getNames()).isEqualTo(Arrays.asList("car1", "car2", "car3"));
  }

  @Test
  void validate_name_length() {
    assertThatThrownBy(() -> new Names(new String[]{"car1", "car2", "car12345"}))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
  }

  @Test
  void size() {
    Names names = new Names(new String[]{"car1", "car2", "car3"});
    assertThat(names.size()).isEqualTo(3);
  }

  @Test
  void getNameByIndex() {
    Names n = new Names(new String[]{"car1", "car2", "car3"});
    assertAll(
        () -> assertThat(n.getNameByIndex(0)).isEqualTo("car1"),
        () -> assertThat(n.getNameByIndex(1)).isEqualTo("car2"),
        () -> assertThat(n.getNameByIndex(2)).isEqualTo("car3")
    );
  }
}
