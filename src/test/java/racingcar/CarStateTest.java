package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarStateTest {
    @DisplayName("자동차 상태 정보 객체 생성 테스팅")
    @Test
    void carStateCreationTest() {
        String name = "TDD";
        Car car = Car.createCar(name);

        CarState state =  car.getState();

        assertThat(state.getName()).isEqualTo(name);
    }
}