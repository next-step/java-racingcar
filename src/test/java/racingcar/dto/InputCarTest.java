package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class InputCarTest {

    @Test
    @DisplayName("'tom' 입력시 'tom' 이름의 Car 객체를 포함한 List<Car>를 반환한다.")
    void StringToCar() {
        assertThat(new InputCar("tom").toCars()).containsExactly(new Car("tom"));
    }

    @Test
    @DisplayName("'tom,anna' 입력시 'tom', 'anna' 이름의 Car 객체를 포함한 List<Car>를 반환한다.")
    void StringToCars() {
        assertThat(new InputCar("tom,anna").toCars()).containsExactly(new Car("tom"), new Car("anna"));
    }
}