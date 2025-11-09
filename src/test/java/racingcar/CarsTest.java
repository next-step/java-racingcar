package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(ints = {1, 3})
    void 생성자_입력한_대수만큼_자동차를_생성한다(int input) {
        assertThat(new Cars(input).size()).isEqualTo(input);
    }

    @Test
    void 생성자_입력한_대수가_1_미만이면_예외발생() {
        assertThatThrownBy(() -> new Cars(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 대수는 1이상이어야 합니다.");
    }

    @Test
    void moveAll_모든_자동차가_이동한다() {
        Cars cars = new Cars(3);
        RandomNumber randomNumber = () -> 4;

        cars.moveAll(randomNumber);

        assertThat(cars.getDistances()).containsExactly(1, 1, 1);
    }

    @Test
    void moveAll_각_자동차는_서로_다른_랜덤값을_받는다() {
        Cars cars = new Cars(4);
        int[] values = {0, 3, 4, 9};
        int[] index = {0};
        RandomNumber randomNumber = () -> values[index[0]++];

        cars.moveAll(randomNumber);

        assertThat(cars.getDistances()).containsExactly(0, 0, 1, 1);
    }
}
