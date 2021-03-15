package study.step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step4.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @DisplayName("차량 등록 확인, 이름")
    @ParameterizedTest
    @ValueSource(strings = {"차량1호", "차량2호", "차량3호"})
    void checkCarName(String carName) {
        Car car = Car.of(carName);
        assertThat(car.getCarName()).isEqualTo(carName);
    }

    @DisplayName("Exception 테스트, 자동차이름 5자 초과")
    @ParameterizedTest
    @ValueSource(strings = {"자동차ABC", "자동차이름6자"})
    void carNameLengthOver(String carName) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car.of(carName);
        }).withMessage("자동차의 이름은 5자를 초과할 수 없습니다.");
    }
}