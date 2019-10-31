package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "4:1", "9:1"}, delimiter = ':')
    @DisplayName("number 판단하여 이동한다.")
    void move(int number, int result) {

        //given
        Car car = new Car("car1");

        //when
        car.move(number);

        //then
        assertThat(car.getLocation()).isEqualTo(result);
    }

    @Test
    @DisplayName("location 이 같은지 판단한다.")
    void name() {

        //given
        Car car = new Car("car1", 5);

        //when
        boolean equals = car.equalsLocation(5);

        //then
        assertThat(equals).isTrue();

    }
}
