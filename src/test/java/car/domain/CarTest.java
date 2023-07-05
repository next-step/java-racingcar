package car.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private final int CAR_MOVING_LIMIT = 4;

    @Test
    @DisplayName("자동차 입력이 정상적인지 확인")
    void 자동차_이름_테스트_정상() {
        String carName = "pobi";
        assertThatCode(() -> new Car(carName)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 입력이 5자 글자 초과로 오류")
    void 자동차_이름_테스트_5자글자_초과_오류() {
        String carName = "pobiii";
        assertThrows(RuntimeException.class, () -> new Car(carName));
    }

    @Test
    @DisplayName("단일 자동차 전진 테스트 정상 동작")
    void 단일_자동차_전진_정상_동작() {
        int amount = 1;
        Car car = new Car("hello");

        car.move(amount);

        Assertions.assertThat(car.getPosition()).isEqualTo(amount);
    }

}
