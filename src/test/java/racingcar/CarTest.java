package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void test_자동차_이름을_5자_초과하여_생성() {
        String name = "일곱글자입니다";

        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @Test
    void test_자동차_정상적으로_생성() {
        String name = "다섯글자임";
        Car car = new Car(name);

        assertEquals(name, car.getName());
    }

    @Test
    void test_성공하여_앞으로_한칸_전진() {
        Car car = new Car("성공");
        car.move(4);
        assertEquals(1, car.getPosition().getPosition());
    }

    @Test
    void test_실패하여_정지() {
        Car car = new Car("실패");
        car.move(0);
        assertEquals(0, car.getPosition().getPosition());
    }
}
