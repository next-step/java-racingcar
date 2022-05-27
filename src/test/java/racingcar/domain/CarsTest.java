package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;


public class CarsTest {
    Cars cars = new Cars("car");

    @Test
    void 차이름_길이_최댓값_초과() {
        assertThatThrownBy(() -> new Cars("나는자동차이름입니다")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 차이름_길이_최솟값_미달() {
        assertThatThrownBy(() -> new Cars("")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 포지션_최댓값_구하기() {
        cars.saveMaxPosition(3);
        cars.saveMaxPosition(5);
        assertThat(cars.maxPosition()).isEqualTo(5);
    }
}
