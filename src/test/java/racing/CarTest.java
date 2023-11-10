package racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 이름과 함께 생성 기능")
    public void make_car_with_name()  {
        // when
        Car car = Car.defaultOf("홍길동");

        // then
        Assertions.assertNotNull(car);
    }

    @Test
    @DisplayName("이름 제한으로 자동차 생성 실패")
    public void fail_to_make_car_because_of_name()  {
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Car.defaultOf("5자가넘어"));
    }
}
