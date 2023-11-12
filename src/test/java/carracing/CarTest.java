package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"0,0","3,0","4,1","9,1"})
    @DisplayName("move()_0~9 입력시 움직임이 일치하는지확인_0~3일때 0, 4~9일때 1")
    void move(int input, int expected) {
        Car car = new Car();
        car.getMove(input);
        assertThat(car.distance).isEqualTo(expected);
    }
}
