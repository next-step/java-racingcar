package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    Position position;

    @BeforeEach
    void init() {
        this.position = new Position();
    }

    @Test
    @DisplayName("Car 2회 전진 성공 테스트")
    void 앞으로_2회_움직이기_성공() {
        assertThat(position.getPosition()).isEqualTo(0);

        position.moveForward();
        position.moveForward();

        assertThat(position.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("Car 전진 실패 테스트(2칸 움직이려고 할 때)")
    void 전진_실패_움직일수있는_거리_초과() {
        assertThatThrownBy(() -> position.setPosition(2))
                .isInstanceOf(InvalidCarException.class)
                .hasMessage("위치가 올바르지 않습니다.");
    }

}
