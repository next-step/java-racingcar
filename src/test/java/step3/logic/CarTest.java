package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @DisplayName("test for car movement")
    @CsvSource({
            "0,0", "1,0", "2,0", "3,0", "4,0",
            "5,1", "6,1", "7,1", "8,1", "9,1",
    })
    @ParameterizedTest
    void run(int throttle, int expectedPosition) {
        Car car = new Car();
        car.run(throttle);
        assertThat(car.getCurrentPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("test for invalid throttle inputs")
    @ValueSource(ints = {Car.THROTTLE_MIN - 2, Car.THROTTLE_MIN -1, Car.THROTTLE_MAX, Car.THROTTLE_MAX + 1})
    @ParameterizedTest
    void illegalThrottle(int throttle) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car().run(throttle))
                .withMessageMatching("invalid throttle range");
    }

    @DisplayName("test for random value ranges")
    @RepeatedTest(20)
    void getThrottle() {
        assertThat(new Car().getThrottle()).isBetween(Car.THROTTLE_MIN, Car.THROTTLE_MAX - 1);
    }
}
