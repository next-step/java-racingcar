package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    @Test
    void 자동차수_시도횟수_입력() {
        int input_car_count = 3;
        int input_try_count = 7;
        Racing racing = new Racing(input_car_count,input_try_count);
        assertThat(racing.cars.size()).isEqualTo(3);
        assertThat(racing.try_count).isEqualTo(7);
    }

    @Test
    void 자동차수_시도횟수_음수_입력() {
        assertThatThrownBy(() -> new Racing(-3,7)).isInstanceOf(IllegalArgumentException.class).hasMessage("음수는 입력할 수 없습니다.");
        assertThatThrownBy(() -> new Racing(3,-7)).isInstanceOf(IllegalArgumentException.class).hasMessage("음수는 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void 값이4이상일때전진(int randomNumber) {
        assertThat(RacingRule.goOrStop(randomNumber)).isEqualTo(RacingRule.go());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void 값이4미만일때정지(int number) {
        assertThat(RacingRule.goOrStop(number)).isEqualTo(RacingRule.stop());
    }
}
