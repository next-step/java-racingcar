package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacerNameValidatorTest {
    @DisplayName("입력된 문자열의 공백을 제거")
    @Test
    void InputValidator_공백_제거() {
        assertThat(RacerNameValidator.replaceAllEmptySpace(" 공 백 문 자 "))
                .isEqualTo("공백문자");
    }
    @DisplayName("입력된 문자열을 쉼표로 구분한다.")
    @Test
    void InputValidator_쉼표로_구분() {
        assertThat(RacerNameValidator.splitByComma("choi,jae,hyeon"))
                .containsExactly("choi", "jae", "hyeon");
    }
    @DisplayName("구분된 문자열은 5자를 초과하면 IllegalArgumentException 이 발생한다.")
    @Test
    void InputValidator_글자수_초과() {
        assertThatThrownBy(() -> {
            String[] value = RacerNameValidator.splitByComma("choi,jae,hyeon,choiJaeHyeon");
        }).isInstanceOf(RuntimeException.class).hasMessage("이름은 " + RacerNameValidator.MAXIMUM_NAME_LENGTH + "자를 초과할 수 없습니다.");
    }
}