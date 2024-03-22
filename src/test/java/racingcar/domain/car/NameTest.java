package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.config.RacingCarException.CAR_NAME_EXCEED_MAXIMUM_LENGTH;
import static racingcar.config.RacingCarException.CAR_NAME_NOT_MATCHES_PATTERN;
import static racingcar.domain.car.Name.NAME_MAXIMUM_LENGTH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "kyle", "123", "ky123"})
    @DisplayName("한 글자 이상의 공백이 없는 영어 소문자와 숫자로 구성된 이름을 생성한다.")
    void from_LowercaseAndNumber_Name(final String value) {
        final Name actualName = Name.from(value);
        final Name expectedName = Name.from(value);

        assertThat(actualName).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @ValueSource(strings = {" a", "a ", " a ", "a\n", "\na", "\na\n", "a\n ", "\n a", " a\n"})
    @DisplayName("양쪽 끝의 공백을 제거한 이름을 생성한다.")
    void from_PaddedSpace_Name(final String value) {
        final Name actualName = Name.from(value);
        final Name expectedName = Name.from(value.trim());

        assertThat(actualName).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "ky le", "$1k", "k 123"})
    @DisplayName("영어 소문자나 숫자 이외의 문자가 포함된 이름을 생성하는 경우 예외를 던진다.")
    void from_SpaceOrSpecialCharacter_Exception(final String invalidValue) {
        assertThatThrownBy(() -> Name.from(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_NOT_MATCHES_PATTERN.message(invalidValue));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", "\n"})
    @DisplayName("빈 문자열, 공백, 개행만으로 구성된 이름을 생성하는 경우 예외를 던진다.")
    void from_Blank_Exception(final String blankValue) {
        assertThatThrownBy(() -> Name.from(blankValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_NOT_MATCHES_PATTERN.message(""));
    }

    @Test
    @DisplayName("최대 길이를 초과하여 이름을 생성하는 경우 예외를 던진다.")
    void from_ExceedMaximumLength_Exception() {
        final String longValue = "a".repeat(NAME_MAXIMUM_LENGTH + 1);

        assertThatThrownBy(() -> Name.from(longValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_EXCEED_MAXIMUM_LENGTH.message(longValue));
    }

    @Test
    @DisplayName("이름 객체 복사 시 참조 값이 다른 동등한 객체를 생성한다.")
    void copyOf_SameNameValue_Name() {
        final Name originName = new Name("kyle");
        final Name copiedName = originName.copyOf();

        assertThat(originName)
                .isNotSameAs(copiedName)
                .isEqualTo(copiedName);
    }

    @ParameterizedTest
    @CsvSource(value = {"kyle,kyle,true", "kyle,alex,false"})
    @DisplayName("이름 문자열 리터럴을 기준으로 동등성을 판단한다.")
    void equals_NameValue_TrueOrFalse(final String originValue, final String targetValue, final boolean isEqualName) {
        final Name originName = new Name(originValue);
        final Name targetName = new Name(targetValue);

        assertThat(originName.equals(targetName))
                .isEqualTo(isEqualName);
    }
}
