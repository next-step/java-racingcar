package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"3:0", "7:1"}, delimiter = ':')
    @DisplayName("자동차 이동 테스트")
    void moveTest(int randomValue, int position) {
        Car car = new Car("testCar");
        assertThat(car.move(randomValue)).isEqualTo(position);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    @DisplayName("자동차의 위치와 우승후보 위치를 비교하여 높은 값을 반환하는지 테스트")
    void getWinnerPositionTest(int position) {
        Car car = new Car("testCar");
        assertThat(car.comparePositionWith(position)).isEqualTo(position);
    }

    @Test
    @DisplayName("자동차의 위치가 입력된 우승후보 위치 보다 큰지 확인")
    void isBiggerThanWinnerPositionTest() {
        Car car = new Car("testCar");
        assertThat(car.isBiggerThanWinnerPosition(3)).isFalse();
    }

    @Test
    @DisplayName("자동차의 위치가 입력된 우승후보 위치와 같은지 확인")
    void isEqualWinnerPositionTest() {
        Car car = new Car("testCar");
        assertThat(car.isEqualWinnerPosition(0)).isTrue();
    }
}