package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PositionTest {

    private Position position;

    @BeforeEach
    public void beforeEach() {
        position = new Position(0);
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - Position 객체가 생성되는지 확인")
    @Test
    void create_position() {
        assertThat(position).isEqualTo(new Position(0));
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 자동차 Position 에 0 미만의 값을 입력한 경우 IllegalArgumentException 예외가 발생하는지 확인")
    @Test
    void pass_invalid_position_value_illegal_argument_exception() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 0 미만 일 수 없습니다.");
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - Position increase() 시 position 값이 1 증가하는지 확인")
    @Test
    void increase_position() {
        assertThat(position.increase()).isEqualTo(new Position(1));
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - Position max() 시 더 큰 position 이 반환되는지 확인")
    @Test
    void max_position() {
        Position maxPosition = new Position(9);
        assertThat(position.max(maxPosition)).isEqualTo(maxPosition);
    }


}
