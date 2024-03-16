package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "kyle", "123", "ky123"})
    @DisplayName("한 글자 이상의 공백이 없는 영어 소문자와 숫자로 이루어진 이름으로 자동차를 생성한다.")
    void from_CarNameWithLowercaseAndNumber_Car(final String carName) {
        assertThat(Car.from(carName).name())
                .isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {" a", "a ", " a ", "a\n", "\na", "\na\n", "a\n ", "\n a", " a\n"})
    @DisplayName("자동차 이름의 양쪽 끝에 존재하는 공백을 제거한 후 자동차를 생성한다.")
    void from_SpacePaddedCarName_Car(final String carName) {
        assertThat(Car.from(carName).name())
                .isEqualTo(carName.trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "ky le", "$1k", "k 123"})
    @DisplayName("영어 소문자나 숫자 이외의 문자가 포함된 이름으로 자동차를 생성하는 경우 예외를 던진다.")
    void from_CarNameWithSpaceOrSpecialCharacter_Exception(final String invalidCarName) {
        assertThatThrownBy(() -> Car.from(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 한 글자 이상의 영어 소문자와 숫자만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", "\n"})
    @DisplayName("빈 문자열, 공백, 개행으로 자동차를 생성하는 경우 예외를 던진다.")
    void from_BlankCarName_Exception(final String blankCarName) {
        assertThatThrownBy(() -> Car.from(blankCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 한 글자 이상의 영어 소문자와 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("최대 길이를 초과한 이름으로 자동차를 생성하는 경우 예외를 던진다.")
    void from_CarNameLongerThanMaximumLength_Exception() {
        final String longCarName = "kyle12";

        assertThatThrownBy(() -> Car.from(longCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5글자를 초과할 수 없습니다.");
    }
}
