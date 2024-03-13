package race.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest(name = "4이상이면_움직이고_3이하이면_움직이지못한다.")
    @CsvSource(value = {"4:1", "5:1", "1:0", "2:0", "3:0"}, delimiter = ':')
    void move(int number, int count) {
        // Given
        Car car = Car.createInstance();

        // When
        car.move(number);

        // Then
        assertThat(car.getPosition()).isEqualTo(count);
    }
}