package edu.nextstep.camp.carracing.domain;

import edu.nextstep.camp.carracing.util.FixedNumberGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @ParameterizedTest
    @CsvSource(value = {"1,0", "4,1"})
    void 차량_이동_테스트(int number, int expectedPosition) {
        // Given
        Cars cars = new Cars(List.of(new Car("car1"), new Car("car2")));

        // When
        FixedNumberGenerator generator = new FixedNumberGenerator(number);
        cars.moveCars(generator);

        // Then
        for (Car car : cars.getValues()) {
            assertThat(car.getPosition().getValue()).isEqualTo(expectedPosition);
        }
    }
}