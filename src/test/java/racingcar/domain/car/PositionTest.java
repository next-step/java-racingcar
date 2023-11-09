package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("5의 위치의 포지션을 생성하면 해당 포지션은 5의 위치를 가진다.")
    void createPosition() {
        Position position = new Position(5);

        assertThat(position).isEqualTo(new Position(5));
    }

    @Test
    @DisplayName("5의 위치인 포지션 객체를 이동하면 6의 포지션을 가진다.")
    void move() {
        Position position = new Position(5);

        Position movePosition = position.move();

        assertThat(movePosition).isEqualTo(new Position(6));
    }

    @Test
    @DisplayName("음수의 숫자로 포지션을 생성할 시  오류가 발생한다.")
    void createPosition_음수() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(-1))
                .withMessage("포지션은 음수값을 가질 수 없습니다.");
    }

}