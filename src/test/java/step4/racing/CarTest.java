package step4.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.racing.Car;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @Test
    @DisplayName("자동차 이름과 함께 생성 기능")
    void make_car_with_name()  {
        // when
        Car car = Car.defaultOf("홍길동");

        // then
        assertNotNull(car);
    }

    @Test
    @DisplayName("이름 제한으로 자동차 생성 실패")
    void fail_to_make_car_because_of_name()  {
        // then
        assertThrows(
                IllegalArgumentException.class
                , () -> Car.defaultOf("5자가넘어")
        );
    }

}
