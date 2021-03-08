package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.mockito.Mockito.*;

public class DriverTest {
    private Driver driver;
    private Car car;

    @BeforeEach
    void setUp() {
        car = mock(Car.class);
        driver = new Driver(car);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("0 ~ 3가 주어질 때는 car의 move()가 실행되면 안 된다.")
    void should_NeverCallToMove_When_ValueLessThan4(int randomValue) {
        driver.drive(() -> randomValue);

        verify(car, never()).move();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4 ~ 9가 주어질 때는 car의 move()가 실행돼야 한다.")
    void should_CallToMove_When_ValueMoreThan3(int randomValue) {
        driver.drive(() -> randomValue);

        verify(car, atLeastOnce()).move();
    }
}
