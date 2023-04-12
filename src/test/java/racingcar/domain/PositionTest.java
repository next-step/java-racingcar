package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("Position 을 생산한다.")
    @Test
    void test01() {
        Position position = Position.init();

        assertThat(position.position()).isEqualTo(0);
    }

    @DisplayName("전진한다.")
    @Test
    void test02() {
        Position position = Position.init();

        position.move(Position.MOVE_POSITION_CONDITION + 1);

        assertThat(position.position()).isEqualTo(1);
    }

    @DisplayName("전진하지 않는다.")
    @Test
    void test03() {
        Position position = Position.init();

        position.move(Position.MOVE_POSITION_CONDITION - 1);

        assertThat(position.position()).isEqualTo(0);
    }

    @DisplayName("움직일 때 0-9 사이의 숫자가 아니면 에러가 발생한다.")
    @Test
    void test04() {
        Position position = Position.init();

        assertThatThrownBy(() -> position.move(999)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("위치 비교")
    @Test
    void test05() {
        Position position = new Position(5);

        assertThat(position.compareTo(new Position(3))).isGreaterThan(0);
    }
}
