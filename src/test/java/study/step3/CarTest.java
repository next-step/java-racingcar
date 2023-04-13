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
}
