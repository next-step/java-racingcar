package study.racing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    void 자동차의_초기_위치는_0이다() {
        Car car = new Car();
        assertEquals(0, car.getPosition());
    }

    @Test
    void 자동차는_전달받은_값이_4이상이면_전진한다() {
        Car car = new Car();
        car.move(4);
        assertEquals(1, car.getPosition());
    }


    @Test
    void 자동차는_전달받은_값이_4미이면_정지한다() {
        Car car = new Car();
        car.move(3);
        assertEquals(0, car.getPosition());
    }
}
