package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class CarsTest {
    Cars cars = new Cars("car");
    @Test
    void 포지션_문자로_출력() {
        assertThat(cars.append(3)).isEqualTo("---");
    }

    @Test
    void 이름_최대자리수_5_초과_여부() {
        assertThat(cars.checkLength("내이름은홍길동")).isFalse();
        assertThat(cars.checkLength("내이름은")).isTrue();
    }

    @Test
    void 최댓값_구하기() {
        assertThat(cars.setMaxPosition(0, 5)).isEqualTo(5);
    }

}
