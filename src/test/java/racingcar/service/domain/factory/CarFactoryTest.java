package racingcar.service.domain.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.domain.Car;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    @DisplayName("정상적으로 car 정보가 생성되는 경우")
    void createCar(String carName) {
        // when
        List<Car> cars = CarFactory.
                create(Collections.singletonList(carName));

        // then
        cars.forEach(car -> assertThat(car.getName()).isEqualTo(carName));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름에 공백이나 null이 들어가는 경우 예외 처리")
    void createCarExecption(String carName) {
        assertThatIllegalArgumentException().isThrownBy(() -> CarFactory.create(Collections.singletonList(carName)));
    }
}
