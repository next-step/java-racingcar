package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.exception.InvalidCarNameException;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차의 시작 지점은 1이다.")
    void initLocationTest() {
        Car car = Car.from("자동차1");
        assertThat(car.getCurrentLocationValue()).isEqualTo(1);
        assertThat(car.getCarNameValue()).isEqualTo("자동차1");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외를 발생시킨다.")
    void initCarNameTest() {
        assertThatThrownBy(() -> Car.from("123456")).isInstanceOf(InvalidCarNameException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:2", "4:2", "3:1"}, delimiter = ':')
    @DisplayName("자동차는 값이 4 이상일 경우 움직인다")
    void moveTest(int value, int expectedLocation) {
        //given
        Car car = Car.from("자동차1");

        //when, then
        assertThat(car.move(value)).isEqualTo(expectedLocation);
    }

}