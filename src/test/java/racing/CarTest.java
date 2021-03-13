package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("distance의 초기값은 0이어야 한다.")
    void distance() {
        final int expected = 0;

        final int distance = car.getDistance();

        assertThat(distance).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    @DisplayName("주어진 값이 0 ~ 3일 때는 정지, 4 ~ 9일 때는 전진해야 한다.")
    void tryMove(String random, String expected) {
        final int randomValue = Integer.parseInt(random);
        final int expectedValue = Integer.parseInt(expected);

        car.tryMove(() -> randomValue);

        assertThat(car.getDistance()).isEqualTo(expectedValue);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("주어진 값이 0보다 작거나, 9보다 큰 경우, IllegalArgumentException 발생")
    void tryMoveThrowIllegalArgumentExceptionWhenLessThanZeroOrGreaterThanNine(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            car.tryMove(() -> input);
        });
    }

    @Test
    @DisplayName("car는 Cloneable의 instance다.")
    void cloneable() {
        assertThat(car).isInstanceOf(Cloneable.class);
    }

    @Test
    @DisplayName("클론된 객체와 distance의 값은 같아야 한다.")
    void cloned() {
        final Car clonedCar = car.clone();

        assertThat(clonedCar.getDistance()).isEqualTo(car.getDistance());
    }
}
