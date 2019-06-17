package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionTest {
    @Test
    void 위치_객체_생성_테스트() {
        Position position = Position.valueOf(1);
        assertThat(position).isInstanceOf(Position.class);
    }

    @Test
    void Position객체는_캐시를_이용한다() {
        Position position1 = Position.valueOf(10);
        Position position2 = Position.valueOf(10);

        assertThat(position1 == position2).isTrue();
    }
}
