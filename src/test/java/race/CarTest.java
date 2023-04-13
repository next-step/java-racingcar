package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static race.Car.move;

public class CarTest {
    @ParameterizedTest(name = "자동차가 {0}의 힘을 받으면 전진한다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차는_4_이상의_값이_주어지면_전진한다(int input) {
        assertThat(move(input)).isTrue();
    }

    @ParameterizedTest(name = "자동차가 {0}의 힘을 받으면 멈춘다")
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차는_4_미만의_값이_주어지면_멈춘다(int input) {
        assertThat(move(input)).isFalse();
    }
}
