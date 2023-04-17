package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    @DisplayName("자동차를 한 칸 앞으로 이동시킬 수 있다.")
    void testMoveCar() {
        Car car = new Car("car name");
        int originalPosition = car.getPosition();

        car.move();

        assertEquals(originalPosition + 1, car.getPosition());
    }
}
