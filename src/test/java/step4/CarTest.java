package step4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car("aaaa");
    }

    @DisplayName("car 생성자 테스트 - 4자 이하")
    @Test
    void carTest() {
        assertEquals(car.getName(), "aaaa");
    }

    @DisplayName("car 생성자 테스트 - 5자 이상")
    @Test
    void carNameSizeOverTest() {
        assertThrows(
                IllegalArgumentException.class, () -> new Car("aaaaa"));
    }

    @DisplayName("car 이동 테스트 - 이동했을 경우")
    @Test
    void carMoveTest() {
        car.move(4);
        assertEquals(car.getPosition(), 2);
    }

    @DisplayName("car 이동 테스트 - 멈췄을경우")
    @Test
    void catStopTest() {
        car.move(3);
        assertEquals(car.getPosition(), 1);
    }


}