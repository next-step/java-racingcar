package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private Position initPosition;

    @BeforeEach
    void setUp() {
        initPosition = Position.createInitPosition();
    }

    @DisplayName("moveValue값이 4이상일 경우 증가")
    @Test
    void increase() {
        initPosition.increase(4);

        assertThat(initPosition).isEqualTo(Position.of(1));
    }

    @DisplayName("moveValue값이 4미만일 경우 증가하지않음")
    @Test
    void notIncrease() {
        initPosition.increase(3);

        assertThat(initPosition).isNotEqualTo(Position.createInitPosition());
    }


}