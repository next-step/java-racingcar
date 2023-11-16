package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class Step5CarTest {

    @Test
    @DisplayName("Car 생성 테스트")
    void car_make_test() {
        // given
        String name = "홍길동";

        // when
        Car car = Car.defaultOf(name);

        // then
        assertThat(car).extracting("name").isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 이름 5자 제한 기능 테스트")
    void name_limit_length() {
        // given
        String name = "이름이5자이상";

        // then
        assertThrowsExactly(IllegalArgumentException.class, () -> Car.defaultOf(name));
    }

}
