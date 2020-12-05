package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("이동 규칙(MoveAble) 테스트")
public class MoveableTest {

    private Moveable moveable;

    @DisplayName("이동이 가능 하다.")
    @Test
    void canMove() {
        // given
        moveable = () -> true;

        // when / then
        assertThat(moveable.isMove()).isTrue();
    }

    @DisplayName("이동이 불가능 하다.")
    @Test
    void cantMove() {
        // given
        moveable = () -> false;

        // when / then
        assertThat(moveable.isMove()).isFalse();
    }
}
