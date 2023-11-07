package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private Position position;

    @BeforeEach
    void init() {
        this.position = new Position();
    }

    @Test
    @DisplayName("포지션을 초기 생성시 위치는 0이다.")
    void createPosition() {
        assertThat(this.position.getPosition()).isZero();
    }
}