package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("차의 출발점은 0")
    @Test
    void getLocation() {
        Car car = Car.of();
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @DisplayName("차량 이동")
    @ParameterizedTest
    @CsvSource(value = {"3:3", "2:2", "7:7"}, delimiter = ':')
    void move(int movingCount, int location) {
        Car car = Car.of();
        while (movingCount-- > 0) {
            car.move();
        }
        assertThat(car.getLocation()).isEqualTo(location);
    }

}
