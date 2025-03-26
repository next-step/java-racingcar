package edu.nextstep.camp.carracing;

import edu.nextstep.camp.carracing.domain.Car;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"0,0", "9,1"})
    void 숫자에_따른_차_이동_후_position_테스트(int number, int expectedPosition) {
        // Given
        Car car = new Car("myCar");

        // When
        car.move(number);

        // Then
        assertThat(car.getPosition().getValue()).isEqualTo(expectedPosition);
    }
}
