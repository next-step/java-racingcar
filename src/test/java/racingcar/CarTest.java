package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("car");
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3"})
    @DisplayName("기준값 미만이면 자동차가 움직이지 않는지 확인")
    public void try_to_move_fail_test(int value) {
        int startLocation = car.getLocation();
        car.tryToMove(value);
        assertThat(car.getLocation()).isEqualTo(startLocation);
    }

    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"})
    @DisplayName("기준값 이상이면 자동차가 움직이는지 확인")
    public void try_to_move_success_test2(int value) {
        int startLocation = car.getLocation();
        car.tryToMove(value);
        assertThat(car.getLocation()).isEqualTo(startLocation +1);
    }
}
