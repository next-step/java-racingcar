package study.racing.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @Test
    void 자동차를_생성하면_이름을_가진다() {
        Car yang = new Car("yang");
        assertEquals("yang", yang.getName());
    }


    @Test
    void 자동차의_초기_위치는_0이다() {
        Car car = new Car("yang");
        assertEquals(0, car.getPosition());
    }

    @Test
    void 자동차는_전달받은_값이_4이상이면_전진한다() {
        Car car = new Car("yang");
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    void 자동차는_전달받은_값이_4미이면_정지한다() {
        Car car = new Car("yang");
        car.move(3);
        assertEquals(0, car.getPosition());
    }

    @Test
    void 자동차의_이름은_5글자까지_생성가능하다() {
        Car car = new Car("12345");
        assertEquals("12345", car.getName());
    }

    @Test
    void 자동차의_이름은_5자를_초과할수없다() {
        assertThrows(IllegalArgumentException.class, () -> new Car("yang555"));
    }

}
