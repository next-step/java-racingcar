package newRacingCar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class PositionTest {
    private Position position = new Position(1);

    @Test
    void 음수_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Position position = new Position(-1);
                });
    }

    @Test
    void 이동_테스트() {
        assertThat(position.move()).isEqualTo(new Position(2));
    }

    @Test
    void 크키_비교_테스트() {
        assertThat(position.findMaxPosition(new Position(3))).isEqualTo(new Position(3));
    }

    @Test
    void 크키_동일_테스트() {
        assertThat(position.isSamePosition(new Position(1))).isTrue();
    }
}
