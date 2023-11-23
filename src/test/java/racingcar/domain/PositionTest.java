package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    @DisplayName("포지션 크기 비교 테스트")
    void posiotion_compare() {
        Position position_small = new Position(3);
        Position position_big = new Position(5);

        assertThat(position_big.comparePosition(position_small)).isTrue();
    }

    @Test
    @DisplayName("포지션 동등성 비교 테스트")
    void position_equals() {
        Position position_a = new Position(3);
        Position position_b = new Position(3);

        assertThat(position_a.equals(position_b)).isTrue();
    }

    @Test
    @DisplayName("포지션 이동 비교 테스트")
    void position_move() {
        Position position = new Position(3);
        position.move();

        assertThat(position.equals(new Position(4))).isTrue();
    }
}
