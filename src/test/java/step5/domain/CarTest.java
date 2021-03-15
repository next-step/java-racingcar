package step5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car("aaaa", 1);
    }

    @DisplayName("car 생성자 확인 - 정상 생성")
    @Test
    void carTest() {
        Car first = new Car("aa", 1);
        Car second = new Car("aa", 1);

        assertEquals(first, second);
    }

    @DisplayName("car 이동 테스트 - 이동했을 경우")
    @Test
    void carMoveTest() {
        car.move(4);
        assertEquals(car.getPosition(), new Position(2));
    }

    @DisplayName("car 이동 테스트 - 멈췄을경우")
    @Test
    void catStopTest() {
        car.move(3);
        assertEquals(car.getPosition(), new Position(1));
    }

}