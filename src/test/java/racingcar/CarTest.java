package racingcar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class CarTest {
    private static MockedStatic<RandomNumberGenerator> randomNumberGenerator;

    @BeforeAll
    static void beforeAll() {
        randomNumberGenerator = mockStatic(RandomNumberGenerator.class);
    }

    @AfterAll
    static void afterAll() {
        randomNumberGenerator.close();
    }

    @ParameterizedTest(name = "4 이상이 나오면 1칸 전진해야 한다. {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void testCarShouldGoWhenRandomNumberIsGreaterOrEqualTo3(int randomNumber) {
        // Given
        Car car = new Car();
        when(RandomNumberGenerator.randomNumber()).thenReturn(randomNumber);

        // When
        car.run();

        // Then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest(name = "4 미만이 나오면 전진할 수 없다. {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    void testCarShouldGoWhenRandomNumberIsLessThan4(int randomNumber) {
        // Given
        Car car = new Car();
        when(RandomNumberGenerator.randomNumber()).thenReturn(randomNumber);

        // When
        car.run();

        // Then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
