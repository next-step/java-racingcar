package car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("단일 자동차 전진 테스트 정상 동작")
    void 단일_자동차_전진_정상_동작() {
        int amount = 1;
        Car car = new Car("hello");

        car.move(amount);

        Assertions.assertThat(car.getPosition()).isEqualTo(amount);
    }
}
