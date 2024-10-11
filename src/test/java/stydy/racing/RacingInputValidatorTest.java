package stydy.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.validation.CountValidator;
import study.validation.NameValidator;
import study.validation.RaceInputValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingInputValidatorTest {

    @ParameterizedTest
    @DisplayName("횟수, 대수 : 공백, 빈 문자열 check")
    @ValueSource(strings = {"", " "})
    public void emptyForCount(String value) {
        RaceInputValidator carCountValidator = new CountValidator();
        assertThat(carCountValidator.validate(value)).isFalse();
    }

    @Test
    @DisplayName("음수 check")
    public void negativeForCount() {
        RaceInputValidator negativeInputValidator = new CountValidator();
        assertThatThrownBy(() -> negativeInputValidator.validate("-1"))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @DisplayName("참여자 : 공백, 빈 문자열 check")
    @ValueSource(strings = {"", "                "})
    public void emptyForParticipant(String value) {
        RaceInputValidator nameInputValidator = new NameValidator();
        assertThat(nameInputValidator.validate(value)).isFalse();
    }

    @Test
    @DisplayName("참여자 split check")
    public void splitNameForParticipant() {
        RaceInputValidator nameInputValidator = new NameValidator();
        assertThat(nameInputValidator.validate("pobbi,conan")).isTrue();
    }
}
