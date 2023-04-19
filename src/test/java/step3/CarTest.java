package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    @DisplayName("자동차를 한 칸 앞으로 이동시킬 수 있다.")
    void testMoveCar() {
        Car car = new Car("name");
        int originalPosition = car.getPositionValue();

        car.move(true);

        assertEquals(originalPosition + 1, car.getPositionValue());
    }
}
