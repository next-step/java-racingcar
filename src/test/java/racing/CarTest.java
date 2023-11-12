package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("자동차 이동 테스트")
    void car_move_test()  {
        // then
        // 자동차를 테스트해야하는데 유지보수 관련해서는 움직임을 판단하는
    }
}
