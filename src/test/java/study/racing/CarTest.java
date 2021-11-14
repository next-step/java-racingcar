package study.racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.racing.model.car.Car;

public class CarTest {

    @DisplayName("random 숫자가 4이상이면 움직이는지 검증")
    @ParameterizedTest
    @CsvSource(value = { "0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1" }, delimiter = ':')
    void move(int randomNumber, int distance) {
        Car car = new Car();
        car.moveOrStop(randomNumber);
        assertThat(car.getDistance()).isEqualTo(distance);
    }
}
