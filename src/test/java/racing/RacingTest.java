package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    @Test
    void 자동차수_시도횟수_입력() {
        int input_car_count = 3;
        int input_try_count = 7;
        Racing race = new Racing(input_car_count,input_try_count);
        assertThat(race.car_count).isEqualTo(3);
        assertThat(race.try_count).isEqualTo(7);
    }

    @Test
    void 자동차수_시도횟수_음수_입력() {
        assertThatThrownBy(() -> new Racing(-3,7)).isInstanceOf(IllegalArgumentException.class).hasMessage("음수는 입력할 수 없습니다.");
        assertThatThrownBy(() -> new Racing(3,-7)).isInstanceOf(IllegalArgumentException.class).hasMessage("음수는 입력할 수 없습니다.");
    }


}
