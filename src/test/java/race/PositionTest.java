package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import race.car.Position;

class PositionTest {

    @Test
    void 생성() {
        Position position = new Position(4);
        assertThat(position).isEqualTo(new Position(4));
    }

    @Test
    void Position은_음수가_아니다() {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Position not allowed minus");
    }

    @Test
    void isMaxPosition으로_가장_멀리간_위치인지_확인한다() {
        Position position = new Position(4);
        assertThat(position.isMaxPosition(4)).isTrue();
    }

    @Test
    void compareWithMaxPosition으로_더_멀리간_위치를_확인한다() {
        Position position = new Position(4);
        assertThat(position.compareWithMaxPosition(5)).isEqualTo(5);
    }

    @Test
    void increase를_하면_값이_1만큼_커진다() {
        Position position = new Position(4);
        Position result = position.increase();

        assertThat(result).isEqualTo(new Position(5));
    }
}
