package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("생성자에 자연수를 전달하면, 정상적으로 Car 객체가 생성된다.")
    void new_PositiveNumber_NewCar() {
        final int number = 1;
        final Car newCar = new Car(number);

        assertThat(newCar.number())
                .isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("생성자에 0 혹은 음의 정수를 전달하면, 예외를 던진다.")
    void new_NegativeOrZeroNumber_Exception(final int negativeOrZeroNumber) {
        assertThatThrownBy(() -> new Car(negativeOrZeroNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 번호는 자연수만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "kyle", "123", "ky123"})
    @DisplayName("영어 소문자와 숫자로 이루어진 자동차 이름을 전달하면, 정상적으로 Car 객체가 생성된다.")
    void new_CarNameWithLowercaseAndNumber_Car(final String carName) {
        assertThat(new Car(carName).name())
                .isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {" a", "a ", " a ", "a\n", "\na", "\na\n", "a\n ", "\n a", " a\n"})
    @DisplayName("자동차 이름의 양쪽 끝에 공백, 개행 문자에 대해서는 무시하고 조건을 판단하여, Car 객체를 생성한다.")
    void new_SpacePaddedCarName_Car(final String carName) {
        assertThat(new Car(carName).name())
                .isEqualTo(carName.trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "ky le", "$1k", "k 123"})
    @DisplayName("특수 문자나 공백이 들어간 자동차 이름을 전달하면, 예외를 던진다.")
    void new_CarNameWithSpaceOrSpecialCharacter_Exception(final String invalidCarName) {
        assertThatThrownBy(() -> new Car(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 한 글자 이상의 영어 소문자와 숫자만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", "\n"})
    @DisplayName("자동차 이름에 빈 문자열, 공백, 개행을 전달하면, 예외를 던진다.")
    void new_BlankCarName_Exception(final String blankCarName) {
        assertThatThrownBy(() -> new Car(blankCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 한 글자 이상의 영어 소문자와 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("최대 길이 초과의 자동차 이름을 전달하면, 예외를 던진다.")
    void new_CarNameLongerThanMaximumLength_Exception() {
        final String longCarName = "kyle12";

        assertThatThrownBy(() -> new Car(longCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5글자를 초과할 수 없습니다.");
    }
}
