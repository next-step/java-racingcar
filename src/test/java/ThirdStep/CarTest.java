package ThirdStep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    final private static int INIT_LOCATION = 0;

    @Test
    @DisplayName("Car를 최초 생성 시 location = 0이다.")
    void Car_초기화() {
        Car car = new Car();

        assertThat(car.getLocation()).isEqualTo(INIT_LOCATION);
    }

    @ParameterizedTest
    @DisplayName("최초 생성되어 location이 0인 Car의 move에 true가 전달되면 location은 1, false가 전달되면 그대로 0이다.")
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void Car_이동(boolean canMoveForward, int location) {
        Car car = new Car();

        car.move(canMoveForward);

        assertThat(car.getLocation()).isEqualTo(location);
    }
}
