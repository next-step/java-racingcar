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

    @Test
    void Position객체끼리_크기_비교가_가능하다() {
        Integer smallNumber = 1;
        Integer bigNumber = 10;
        Position position1 = Position.valueOf(smallNumber);
        Position position2 = Position.valueOf(bigNumber);

        assertThat(position1.compareTo(position2)).isEqualTo(smallNumber.compareTo(bigNumber));
    }
}
