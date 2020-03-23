package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7, 10, 100})
    public void testCreateCars(int numberOfCars) {
        // Given
        // When
        List<Car> cars = CarFactory.createCars(numberOfCars);
        // Then
        assertThat(cars).hasSize(numberOfCars);
    }
}
