package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차는 Power가 true 면 이동하고 false 면 이동하지 않는다.")
    @ParameterizedTest
    @CsvSource({"true,1", "false,0"})
    void move(boolean power, int location) {
        Car car = new Car();

        int actualLocation = car.move(() -> power);

        assertThat(actualLocation).isEqualTo(location);
    }
}
