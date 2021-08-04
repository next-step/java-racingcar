package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    private Position position;

    @BeforeEach
    void init() {
        this.position = new Position();
    }

    @Test
    @DisplayName("Position 처음 위치 확인 테스트")
    void 처음_위치_0_테스트() {
        assertThat(position.getPosition()).isEqualTo(0);
    }
}
