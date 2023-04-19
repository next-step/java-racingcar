package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingTest {
    @Test
    void 자동차이름_및_시도횟수_입력() {
        String input_car_names = "pobi,crong,honux";
        int input_try_count = 7;
        Racing racing = new Racing(input_car_names,input_try_count);
        assertAll(
                () -> assertThat(racing.getCarsCount()).isEqualTo(3),
                () -> assertThat(racing.getTryCount()).isEqualTo(7)
        );
    }

    @Test
    void 시도횟수_음수_입력() {
        String input_car_names = "pobi,crong,honux";
        assertAll(
                () -> assertThatThrownBy(() -> new Racing(input_car_names,-1)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Racing(input_car_names,-7)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void 값이4이상일때전진(int randomNumber) {
        assertThat(RacingRule.moveOrStop(randomNumber)).isEqualTo(RacingRule.move());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void 값이4미만일때정지(int number) {
        assertThat(RacingRule.moveOrStop(number)).isEqualTo(RacingRule.stop());
    }


    @Test
    void 자동차이름부여() {
        String input_car_names = "pobi,crong,honux";
        int input_try_count = 5;
        Racing racing = new Racing(input_car_names,input_try_count);
        assertAll(
                () -> assertThat(racing.getCarName(0)).isEqualTo("pobi"),
                () -> assertThat(racing.getCarName(1)).isEqualTo("crong"),
                () -> assertThat(racing.getCarName(2)).isEqualTo("honux")
        );
    }

    @Test
    void 자동차이름길이초과() {
        assertAll(
                () -> assertThatThrownBy(() -> new Racing("pobi,tooLongName,honux",5)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Car("tooLongName")).isInstanceOf(IllegalArgumentException.class)
        );
    }

}
