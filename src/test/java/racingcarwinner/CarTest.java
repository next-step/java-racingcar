package racingcarwinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @DisplayName("move 수행 횟수 만큼 location 증가")
    @ParameterizedTest
    @CsvSource(value = {"3,4", "5,6"})
    void move_수행_후_location_증가(int input, int expected) {
        Car car = new Car("test", 1);
        for (int i = 0; i < input; i++) {
            car.move();
        }
        assertThat(car.getLocation()).isEqualTo(expected);
    }
}