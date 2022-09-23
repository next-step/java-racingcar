package racinggame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:0", "4:1"}, delimiter = ':')
    void 자동차가_조건에따라_이동한다(int inputRandomNumber, int inputDistance) {
        //given
        Car car = new Car();

        //when
        car.move(inputRandomNumber);

        //then
        assertThat(car.distance()).isEqualTo(inputDistance);
    }
}