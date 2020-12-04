package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position();
    }

    @Test
    @DisplayName("초기값 test")
    void initialPosition() {
        assertThat(position.getPosition()).isEqualTo(0);
    }
    @Test
    @DisplayName("이동 test")
    void movePosition() {
        position.move(4);
        position.move(3);
        position.move(9);
        position.move(10);
        assertThat(position.getPosition()).isEqualTo(2);
    }

}
