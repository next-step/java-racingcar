package racing.car.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PositionTest {

    @Test
    @DisplayName("move 메서드는 3 이하인 경우 position은 증가하지 않는다.")
    void 앞으로_이동_4이하() {
        Position position = new Position();
        position.increase(3);

        assertThat(position).isEqualTo(new Position(0));

    }

    @Test
    @DisplayName("move 메서드는 4 이상인 경우 position이 1증가 된다.")
    void 앞으로_이동_4이상() {
        Position position = new Position();
        position.increase(4);

        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("Position 클래스의 position 값을 비교하여 같으면 True, 다르면 False")
    void same_메서드_테스트() {
        Position position = new Position(1);

        assertThat(position.isSame(1)).isTrue();
        assertThat(position.isSame(0)).isFalse();
    }

    @Test
    @DisplayName("max 최대값 반환 테스트")
    void max_최대값_테스트() {
        Position position = new Position(5);
        int max = position.max(3);

        assertThat(max).isEqualTo(5);
    }
}