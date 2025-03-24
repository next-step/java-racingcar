package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racing.domain.CarFactory.DEFAULT_MOVE_POWER_CONDITION;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이름은 1글자 이상, 5글자 이하여야 한다.")
    @ValueSource(strings = {"", "123456"})
    void testTooLongCarNameLength(String carName) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(carName);
        });
    }

    @Test
    public void 자동차의_시작위치는_1이다() {
        Car car = new Car("car1");
        assertThat(car.isSamePosition(1));
    }

    @Test
    public void 랜덤값이_4이상일경우_이동한다() {
        int randomValue = 4;
        Car car = new Car("car1", () -> randomValue >= DEFAULT_MOVE_POWER_CONDITION);
        car.move();
        assertThat(car.isSamePosition(2));
    }

    @Test
    public void 랜덤값이_4이하일경우_이동하지않는다() {
        int randomValue = 3;
        Car car = new Car("car1", () -> randomValue >= DEFAULT_MOVE_POWER_CONDITION);
        car.move();
        assertThat(car.isSamePosition(1));
    }
}