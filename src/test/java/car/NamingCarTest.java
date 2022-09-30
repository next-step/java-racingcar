package car;

import static org.assertj.core.api.Assertions.*;

import car.domain.NamingCar;
import car.strategy.CarMovableStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NamingCarTest {
    @DisplayName("랜덤 발생 숫자가 4미만인 경우")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void car_random_under_4(int randomNum) {
        NamingCar car = new NamingCar(() -> {
            return 4 <= randomNum;
        });
        car.inputName("test");
        car.racing();
        assertThat(car.printResult()).isEqualTo("test : ");
    }

    @DisplayName("랜덤 발생 숫자가 4이상인 경우")
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8, 9 })
    void car_random_upper_4(int randomNum) {
        NamingCar car = new NamingCar(() -> {
            return 4 <= randomNum;
        });
        car.inputName("test");
        car.racing();
        assertThat(car.printResult()).isEqualTo("test : - ");
    }

    @DisplayName("차 이름이 5를 넘기면 Exception")
    @Test
    void car_name_test() {
        NamingCar car = new NamingCar(new CarMovableStrategy());
        assertThatThrownBy(() -> {
            car.inputName("123455");
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
    }
}