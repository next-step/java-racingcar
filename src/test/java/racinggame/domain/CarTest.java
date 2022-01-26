package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import calculator.domain.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("5자가 넘는 자동차 이름 입력")
    @Test
    void 자동차_이름_체크() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> Car.of("123456"));
    }

    @DisplayName("자동차가 전진하는지 확인")
    @Test
    void 자동차_이동() {
        Car testCar1 = Car.of("test1");
        Car testCar2 = Car.of("test2");
        testCar1.moveForward();
        Assertions.assertThat(testCar1.getLocation()).isEqualTo(1);
        Assertions.assertThat(testCar2.getLocation()).isEqualTo(0);
    }
}