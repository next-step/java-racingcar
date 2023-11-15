package car;

import car.domain.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    private Position position;

    @BeforeEach
    void setCar() {
        position = new Position(5);
    }

    @DisplayName("increase 함수 테스트")
    @Test
    void 증가_테스트() {
        Position position = new Position(0);

        position.increase();

        assertThat(position.carPosition()).isEqualTo(1);
    }

    @DisplayName("compareCarPosition 함수 테스트")
    @Test
    void max_테스트() {
        assertThat(position.compareCarPosition(7)).isEqualTo(7);
    }

    @DisplayName("isSameMax 함수 테스트")
    @Test
    void max값과같은지_테스트() {
        assertThat(position.isSameMax(5)).isTrue();
    }
}
