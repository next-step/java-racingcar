package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("전진 테스트")
    @Test
    void 전진_테스트() {
        Position position = new Position(0);

        position.move(() -> true);

        assertThat(position).isEqualTo(new Position(1));
    }

    @DisplayName("정지 테스트")
    @Test
    void 정지_테스트() {
        Position position = new Position(0);

        position.move(() -> false);

        assertThat(position).isEqualTo(new Position(0));
    }

    @DisplayName("이동거리가 같은지 테스트")
    @Test
    void 이동거리가_같은지_테스트() {
        Position position = new Position(5);

        assertThat(position.equalsPosition(5)).isTrue();
    }

    @DisplayName("이동거리가 다른지 테스트")
    @Test
    void 이동거리가_다른지_테스트() {
        Position position = new Position(5);

        assertThat(position.equalsPosition(3)).isFalse();
    }

}