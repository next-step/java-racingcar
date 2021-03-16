package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @DisplayName("random 값이 4 이상인 경우 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveOrStay_moveTest(int value) {
        // given
        Car testCar = new Car("test");

        // when
        testCar.moveOrStay(value);

        // then
        assertThat(testCar.getPosition()).isEqualTo(Car.INITIAL_POSITION + 1);
    }

    @DisplayName("random 값이 4 미만인 경우 정지한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void moveOrStay_stayTest(int value) {
        // given
        Car testCar = new Car("test");

        // when
        testCar.moveOrStay(value);

        // then
        assertThat(testCar.getPosition()).isEqualTo(Car.INITIAL_POSITION);
    }

    @DisplayName("이름이 5자를 초과하는 경우 IllegalArgumentException 을 던진다")
    @Test
    void newCar_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("123456"));
    }

    @DisplayName("이름이 5자 이하인 경우 포지션이 1이고 이름이 입력받은 이름인 car 객체를 생성한다.")
    @Test
    void newCar_success() {
        String carName = "12345";
        Car car = new Car(carName);
        assertThat(car)
                .extracting("name", "position")
                .contains(carName, 1);

    }
}
