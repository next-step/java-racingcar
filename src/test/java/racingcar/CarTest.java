package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "4:1", "9:1"}, delimiter = ':')
    @DisplayName("number 판단하여 이동한다.")
    void move(int number, int result) {

        //given
        Car car = new Car();

        //when
        car.move(number);

        //then
        assertThat(car.getLocation()).isEqualTo(result);
    }
}
