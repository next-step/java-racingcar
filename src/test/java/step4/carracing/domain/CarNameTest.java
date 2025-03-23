package step4.carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

  @DisplayName("자동차 이름이 5자 이하인 경우 에러를 반환한다.")
  @Test
  void testCreateCarNameWithLongName() {
    String longName = "longName";

    assertThatThrownBy(() -> new CarName(longName))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("이름은 5자 이하여야 합니다.");
  }

  @DisplayName("자동차 이름이 null인 경우 에러를 반환한다.")
  @Test
  void testCreateCarNameWithNullName() {
    String nullName = null;

    assertThatThrownBy(() -> new CarName(nullName))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("이름은 null이거나 빈 문자열일 수 없습니다.");
  }

  @DisplayName("자동차 이름이 빈 문자열인 경우 에러를 반환한다.")
  @Test
  void testCreateCarNameWithEmptyName() {
    String emptyName = "";

    assertThatThrownBy(() -> new CarName(emptyName))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("이름은 null이거나 빈 문자열일 수 없습니다.");
  }
}