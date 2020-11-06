package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @ParameterizedTest
    @DisplayName("숫자 4 이상 일 때 전진")
    @ValueSource(ints = {4, 9})
    public void 전진_테스트(int value) {
        Car car = new Car();
        car.move(value);
        assertEquals(car.getPosition(), 1);
    }

    @ParameterizedTest
    @DisplayName("숫자 4 이하인 경우 움직이지 않는다.")
    @ValueSource(ints = {1, 3})
    public void 자동차_멈춤_테스트(int value) {
        Car car = new Car();
        car.move(value);
        assertEquals(car.getPosition(), 0);
    }

}
