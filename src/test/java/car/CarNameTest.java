package car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

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
        assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }

}
