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
    @DisplayName("Car 2회 전진 성공 테스트")
    void 앞으로_2회_움직이기_성공() {
        assertThat(position.getPosition()).isEqualTo(0);

        position.moveForward();
        position.moveForward();

        assertThat(position.getPosition()).isEqualTo(2);
    }
}
