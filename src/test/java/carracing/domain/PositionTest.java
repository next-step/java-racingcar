package carracing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void positionByNegativeTest() {

        // given
        int input = -1;

        // when & given
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Position(input))
            .withMessageMatching("현재 위치는 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차가 move하면 위치가 1 증가한다.")
    void positionMoveTest() {

        // given
        Position position = new Position();

        // when
        position.move();

        // given
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("다른 위치와 큰값 비교했을 때 현재 위치가 더 크면 현재 위치가 반환된다.")
    void positionCalBiggerTest() {

        // given
        Position input = new Position(3);
        Position comparePosition = new Position(1);

        // when
        Position result = input.calBiggerPosition(comparePosition);

        // then
        assertThat(result).isEqualTo(input);
    }

    @Test
    @DisplayName("다른 위치와 큰값 비교했을 때 현재 위치가 더 작으면 다른 위치가 반환된다.")
    void positionCalSmallerTest() {

        // given
        Position input = new Position(1);
        Position comparePostion = new Position(3);

        // when
        Position result = input.calBiggerPosition(comparePostion);

        // then
        assertThat(result).isEqualTo(comparePostion);
    }

}