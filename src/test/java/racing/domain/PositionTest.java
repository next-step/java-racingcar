package racing.domain;

import base.BaseMethodSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

  @ParameterizedTest
  @DisplayName("자동차 위치 원시값 클래스 생성")
  @MethodSource(BaseMethodSource.RANDOM_NUMBER_BELOW_10)
  void create(int position) {
    // given

    // when
    Position newPosition = Position.create(position);

    // then
    assertThat(newPosition).isEqualTo(Position.create(position));
  }

  @Test
  @DisplayName("자동차 위치는 반드시 양수만 관리한다. 음수일 경우엔 exception 처리")
  void notCreate() {
    // given
    int negativeInt = -1;

    // when

    // then
    assertThatThrownBy(() -> Position.create(negativeInt))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("자동차 위치 증가 테스트")
  void move() {
    // given
    Position position = Position.create(3);

    // when
    position = position.move();

    // then
    assertThat(position).isEqualTo(Position.create(4));
  }
}
