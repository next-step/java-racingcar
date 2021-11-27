package study.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racinggame.domain.car.Engine;

import static org.assertj.core.api.Assertions.assertThat;

class EngineTest {

    @Test
    @DisplayName("0에서 9 사이의 엔진 수치를 설정한다")
    void shouldReturnRandomNumberBetweenZeroToNine() {
        Engine engine = new Engine();
        assertThat(engine.getValue()).isBetween(0, 9);
    }

    @Test
    @DisplayName("엔진 수치가 4 미만이면 작동할 수 없다")
    void shouldReturnFalse() {
        Engine engine = new Engine(3);
        assertThat(engine.canWork()).isFalse();
    }

    @Test
    @DisplayName("엔진 수치가 4 이상이면 작동할 수 있다")
    void shouldReturnTrue() {
        Engine engine = new Engine(4);
        assertThat(engine.canWork()).isTrue();
    }
}