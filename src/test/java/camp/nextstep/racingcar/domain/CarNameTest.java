package camp.nextstep.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

  @Test
  @DisplayName("자동차 이름 생성")
  void givenCarName_shouldCreatedCarName() {
    assertThat(new CarName("테슬라")).isEqualTo(new CarName("테슬라"));
  }

  @Test
  @DisplayName("자동차 이름 비어있지 않고 5글자 이상일 경우 예외 발생")
  void givenCarName_shouldNotEmptyAndFiveWord() {
    assertThatThrownBy(() -> new CarName("내차는다섯글자가넘어요"))
        .isInstanceOf(IllegalArgumentException.class);
  }

}