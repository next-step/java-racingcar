package step3.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.WrongGameSettingException;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"c", "car2", "car_3"})
    @DisplayName("자동차 이름은 5글자 이하라면 아무런 예외없이 생성될수있다.")
    void carName_ok(String carNameString) {
        assertThatCode(() -> {
            new CarName(carNameString);
        }).doesNotThrowAnyException();

    }

    @ParameterizedTest
    @ValueSource(strings = {"car_45", "car2222", "super_car_1"})
    @DisplayName("자동차 이름이 5글자를 초과하면, 예외를 던진다..")
    void carName_ng(String carNameString) {

        assertThatThrownBy(() -> {
            new CarName(carNameString);
        }).isInstanceOf(WrongGameSettingException.class);
    }
}