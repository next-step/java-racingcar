package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1", "9:1"}, delimiter = ':')
    @DisplayName("move()은 4 이상의 랜덤 숫자가 있으면 움직인다.")
    void move(int random, int distance) {
        Car car = new Car();
        car.move(random);
        assertThat(car.getDistance()).isEqualTo(distance);
    }
}
