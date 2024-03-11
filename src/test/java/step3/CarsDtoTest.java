package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.service.CarsDto;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsDtoTest {

    @DisplayName("랜덤 움직임 차량 목록 생성자에 양수를 선언할 경우 일급 컬렉션의 리스트는 비어 있지 않다.")
    @Test
    void randomStrategyCars() {
        final CarsDto cars = CarsDto.randomStrategyCars(3);

        assertThat(cars.isEmpty()).isFalse();
    }

    @DisplayName("랜덤 움직임 차량 목록 생성자에 0이나 음수를 선언할 경우 일급 컬렉션의 리스트는 비어 있다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void randomStrategyCars(int carCount) {
        final CarsDto cars = CarsDto.randomStrategyCars(carCount);

        assertThat(cars.isEmpty()).isTrue();
    }
}
