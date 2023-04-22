package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    @DisplayName("자동차를 한 칸 앞으로 이동시킬 수 있다.")
    void testMoveCar() {
        Car car = new Car("name");
        int originalPosition = car.getPositionValue();

        car.move(true);

        assertEquals(originalPosition + 1, car.getPositionValue());
    }

    @Test
    @DisplayName("랜덤 값이 작을 경우 자동차는 이동할 수 없다.")
    void testDoNotMoveCar() {
        Car car = new Car("name");
        int originalPosition = car.getPositionValue();

        car.move(false);

        assertEquals(originalPosition, car.getPositionValue());
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void testValidateCarName(){
        assertThrows(IllegalArgumentException.class, () -> new Car("123456"));
    }
}
