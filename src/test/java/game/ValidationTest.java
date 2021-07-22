package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    private Validation validation;

    @BeforeEach
    void setup() {
        Utils utils = new Utils();
        validation = new Validation(utils);
    }

    @Test
    @DisplayName("빈값을 입력하면 예외가 발생된다")
    public void validStringEmpty_check() {
        assertThatThrownBy(() -> validation.validStringEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 최소 1대 이상이어야 한다.");
    }

    @Test
    @DisplayName("자동차이름의 길이가 5자리를 넘어가면 예외가 발생된다.")
    public void validStringLength_check() {
        assertThatThrownBy(() -> validation.validStringLength("nextstep", 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자를 초과할수 없습니다.");
    }

    @Test
    @DisplayName("문자열에 숫자이외의 문자가 포함되어 있으면 예외가 발생된다.")
    public void validNumber_check() {
        assertThatThrownBy(() -> validation.validNUmberChecK("12!"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 문자는 숫자만 사용 가능합니다.");
    }

}