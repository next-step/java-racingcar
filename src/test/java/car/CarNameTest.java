package car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.model.Car;
import car.model.CarName;
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

    @Test
    @DisplayName("서로 다른 이름을 가지는 자동차 이름은 다른 객체이다.")
    void 다른_자동차_이름_다른_객체() {
        final CarName neo = new CarName("Jong");
        final CarName neo2 = new CarName("Jong1");

        assertThat(neo).isNotEqualTo(neo2);

    }

    @Test
    @DisplayName("서로 같은 이름을 가지는 자동차 이름은 같은 객체이다.")
    void 같은_자동차_이름_같은_객체() {
        final CarName neo = new CarName("Jong");
        final CarName neo2 = new CarName("Jong");

        assertThat(neo).isEqualTo(neo2);

    }
}
