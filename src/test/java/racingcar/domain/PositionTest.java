package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.exception.PositionInvalidException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("음수으로 포지션 생성시 PositionInvalidException 에러가 발생한다.")
    void positive() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(PositionInvalidException.class)
                .hasMessage("포지션 값은 0 이상의 값만 가능합니다.");
    }

    @Test
    @DisplayName("up을 하면 position 이 1 증가한다.")
    void up() {
        Position position = new Position(0);
        position.up();

        assertThat(position).isEqualTo(new Position(1));
    }
}