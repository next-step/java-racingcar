package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest(name = "4 이상이 나오면 1칸 전진해야 한다. {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void testCarShouldGoWhenRandomNumberIsGreaterOrEqualTo3(int randomNumber) {
        // Given
        Car car = new Car();

        // When
        car.run(new RandomNumber(randomNumber));

        // Then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest(name = "4 미만이 나오면 전진할 수 없다. {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    void testCarShouldGoWhenRandomNumberIsLessThan4(int randomNumber) {
        // Given
        Car car = new Car();

        // When
        car.run(new RandomNumber(randomNumber));

        // Then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
