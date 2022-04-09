package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차의 시작 지점은 1이다.")
    void initLocationTest() {
        Car car = new Car();
        assertThat(car.getCurrentLocation()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:2", "4:2", "3:1"}, delimiter = ':')
    @DisplayName("자동차는 값이 4 이상일 경우 움직인다")
    void moveTest(int value, int expectedLocation) {
        //given
        Car car = new Car();

        //when, then
        assertThat(car.move(value)).isEqualTo(expectedLocation);
    }

}