package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    private Validation validation;

    @BeforeEach
    void setup() {
        validation = new Validation();
    }

    @Test
    @DisplayName("빈값을 입력하면 예외가 발생된다")
    public void validStringEmpty_check() {
        assertThatThrownBy(() -> validation.validStringEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 최소 1대 이상이어야 한다.");
    }

    @ParameterizedTest
    @DisplayName("문자열을 입력하면 길이가 반환된다.")
    @CsvSource(value = {"nextstep,8","test,4"})
    public void stringToIntSize(String value, int length) {
        int result = validation.StringLength(value);

        assertThat(result).isEqualTo(length);
    }

    @Test
    @DisplayName("자동차이름의 길이가 5자리를 넘어가면 예외가 발생된다.")
    public void validStringLength_check() {
        assertThatThrownBy(() -> validation.validStringLength("nextstep", 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자를 초과할수 없습니다.");
    }

}