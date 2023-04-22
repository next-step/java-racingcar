package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TestMoveStrategyTest {

    private TestMoveStrategy stopStrategy;
    private TestMoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        stopStrategy = new TestMoveStrategy(false);
        moveStrategy = new TestMoveStrategy(true);
    }

    @DisplayName("moveStrategy.move() 호출시 항상 true가 나와야한다.")
    @Test
    void 전진() {
        assertAll(
                () -> assertThat(moveStrategy.isMove()).isTrue(),
                () -> assertThat(moveStrategy.isMove()).isTrue(),
                () -> assertThat(moveStrategy.isMove()).isTrue()
        );
    }

    @DisplayName("stopStrategy.move() 호출시 항상 false가 나와야한다.")
    @Test
    void 정지() {
        assertAll(
                () -> assertThat(stopStrategy.isMove()).isFalse(),
                () -> assertThat(stopStrategy.isMove()).isFalse(),
                () -> assertThat(stopStrategy.isMove()).isFalse()
        );
    }

}