package step3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차는 4 이상의 값을 받으면 한 칸을 움직인다")
    void canMove() {
        Car car = new Car();
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("자동차는 3 이하의 값을 받으면 움직이지 않는다")
    void canNotMove() {
        Car car = new Car();
        car.move(3);
        assertEquals(0, car.getPosition());
    }
}