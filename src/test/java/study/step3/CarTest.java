package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car = new Car();

    @Test
    @DisplayName("0~9 사이 무작위 값을 반환한다.")
    public void random_함수_test() throws Exception {
        for (int i = 0; i < 10; i++) {
            assertThat(car.getRandomInt())
                    .isGreaterThan(-1)
                    .isLessThan(10);
        }
    }

    @Test
    @DisplayName("전달 받은 값이 4 이상일 경우 true를 반환한다.")
    public void car_move_test() throws Exception {
        assertThat(car.isExceedStandard(5)).isTrue();
        assertThat(car.isExceedStandard(4)).isTrue();
        assertThat(car.isExceedStandard(3)).isFalse();
    }
}
