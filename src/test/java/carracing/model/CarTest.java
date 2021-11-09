package carracing.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import carracing.exception.ArgumentOutOfRangeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"donghyo", "dongki"})
    void 자동차이름_초과_예외처리(String carName) {
        assertThatExceptionOfType(ArgumentOutOfRangeException.class)
            .isThrownBy(() -> Car.from(carName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"dong", "hyo"})
    void 자동차_정상_생성_및_이름확인(String carName) {
        assertThat(Car.from(carName).getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"dong", "hyo"})
    void 자동차_전진시_이력_증가(String carName) {
        Car car = Car.from(carName);
        Long before = car.getSuccessCount();

        car.runRace();
        Long after = car.getSuccessCount();

        assertThat(before).isLessThan(after);
    }

}
