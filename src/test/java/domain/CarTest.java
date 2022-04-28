package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @DisplayName("자동차 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void moveTest(boolean movable, int position) {
        Car car = new Car("user");
        car.move(() -> movable);
        Assertions.assertThat(car).isEqualTo(new Car("user", position));
    }
}
