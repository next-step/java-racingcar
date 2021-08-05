package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PositionTest {

    @Test
    @DisplayName("Position 이 정상적으로 만들어지는 지 테스트")
    public void createPositionTest() {
        Position position = new Position();
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("음수 값의 위치가 주어지면 에러 테스트")
    public void negativePositionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Position(-1));
    }

    @Test
    @DisplayName("한칸 앞으로 이동 테스트")
    public void movePositionTest() {
        Position position = new Position(3);
        assertThat(position.moveForward()).isEqualTo(new Position(4));
    }
}
