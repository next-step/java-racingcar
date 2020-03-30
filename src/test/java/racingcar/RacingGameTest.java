package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("Car 의 이동 여부를 결정지을 AlwaysNineEngine 객체는 항상 9를 반환한다")
    @Test
    void generateNumberNine() {
        Engine engine = new AlwaysNineEngine();

        assertThat(engine.generateNumber()).isEqualTo(9);
        assertThat(engine.generateNumber()).isEqualTo(9);
        assertThat(engine.generateNumber()).isEqualTo(9);
    }

    @DisplayName("Engine 구현체에서 최근에 생성한 값을 테스트한다")
    @Test
    void generateNumberTest() {
        Engine nineEngine = new AlwaysNineEngine();
        Engine randomEngine = new RandomEngine();

        assertThat(nineEngine.generateNumber()).isEqualTo(9);
        assertThat(randomEngine.generateNumber()).isEqualTo(randomEngine.getPreviousNumber());
    }
}