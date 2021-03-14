package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("Random값이 4이상일 경우 자동차의 위치가 증가한다")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,1", "2,1", "3,1", "4,2", "5,2", "6,2", "7,2", "8,2", "9,2"})
    public void move(int randomNum, int location) {
        // given
        Car car = new Car();

        // when
        car.move(randomNum);

        // then
        assertThat(car.getLocation()).isEqualTo(location);
    }
}