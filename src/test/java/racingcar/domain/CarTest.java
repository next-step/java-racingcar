package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.RandomGenerator;
import racingcar.view.InputView;

class CarTest {

    @Test
    @DisplayName("자동차 이동 테스트")
    void move() {
        Car car = new Car("chh", 1);
        car.move(() -> true);
        assertThat(car.getLocation()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 정지 테스트")
    void stop() {
        Car car = new Car("chh", 1);
        car.move(() -> false);
        assertThat(car.getLocation()).isEqualTo(1);
    }
}