package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest(name = "숫자 {0} 일때 {1} 이동")
    @CsvSource({"0, 0", "1, 0", "2, 0", "3, 0", "4, 1", "5, 1", "6, 1", "7, 1", "8, 1", "9, 1"})
    void 숫자_4_미만일때는_차_위치_변경_없음_4_이상일때_한칸_전진(int number, int expected) {
        Car car = new Car();
        car.move(new MovingRule(number));

        assertThat(car.getPosition()).isEqualTo(expected);
    }

}
