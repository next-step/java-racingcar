package race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import race.vehicle.Car;
import race.vehicle.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRaceTest {
    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    @DisplayName("숫자를 입력받으면 자동차가 성공적으로 생성되는지 확인한다")
    void 자동차_생성(int value) {
        Cars cars = new Cars(value);

        Assertions.assertThat(cars.getCars()).hasSize(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1})
    @DisplayName("2 미만의 숫자를 입력받으면 예외를 발생시킨다")
    void 자동차_부족(int value) {
        assertThatThrownBy(() -> {
            Cars cars = new Cars(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임을 진행할 수 없음");
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    void 자동차_전진() {
        Car car = new Car();

        car.move(() ->5);

        assertThat(car.getLocation()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 전진 실패 테스트")
    void 자동차_전진_실패() {
        Car car = new Car();

        car.move(() -> 2);

        assertThat(car.getLocation()).isEqualTo(1);
    }
}
