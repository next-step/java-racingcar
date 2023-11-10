package study.step4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step4.domain.Car;
import study.step4.exception.CarException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {


    @ParameterizedTest(name = "자동차_이름_1자_미만_5자_초과: {0}")
    @ValueSource(strings = {"마세라티 기블리", ""})
    void 자동차_이름_1자_미만_5자_초과(String string) {
        assertThatExceptionOfType(CarException.class)
            .isThrownBy(() -> new Car(string))
            .withMessageContaining("CarNameError");
    }

    @ParameterizedTest(name = "자동차 전진 조건 테스트: {0}")
    @ValueSource(ints = {4, 7, 9})
    void 자동차_전진_조건(int randomValue) {
        Car car = new Car("소나타");
        int previousPosition = car.getPosition();
        car.move(randomValue);
        assertThat(car.getPosition()).isEqualTo(previousPosition + 1);
    }

    @ParameterizedTest(name = "자동차 정지 조건 테스트: {0}")
    @ValueSource(ints = {0, 1, 3})
    void 자동차_정지_조건(int randomValue) {
        Car car = new Car("소나타");
        int previousPosition = car.getPosition();
        car.move(randomValue);
        assertThat(car.getPosition()).isEqualTo(previousPosition);
    }
}
