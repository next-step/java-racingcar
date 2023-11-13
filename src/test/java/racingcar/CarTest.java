package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void test_자동차_이름을_5자_초과하여_생성() {
        String name = "일곱글자입니다";

        assertThrows(IllegalArgumentException.class, () -> {
            new Car(name);
        });
    }

    @Test
    void test_자동차_정상적으로_생성() {
        String name = "다섯글자임";
        Car car = new Car(name);

        assertEquals(name, car.getName());
    }

}
