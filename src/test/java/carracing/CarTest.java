package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"1:0:0", "1:1:1", "1:5:5", "2:3:6"}, delimiter = ':')
    @DisplayName("Car의 postion에 Strategy 반환 값을 더해줍니다.")
    void testMove(int strategyReturn, int moveCount, int expected) {
        Car car = new Car(() -> strategyReturn);

        for(int i = 0; i < moveCount; i++) {
            car.move();
        }

        assertThat(car.position()).isEqualTo(expected);
    }
}