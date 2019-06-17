package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.model.CarValidator.*;

class CarValidatorTest {

    @DisplayName("이름 정규식 테스트")
    @Test
    void regexCarName() {
        String regex = REGEX_PATTERN;
        Pattern compile = Pattern.compile(regex);
        assertThat(compile.matcher("test1").find()).isTrue();
    }

    @DisplayName("자동차 이름 유효성 검사 통합 테스트")
    @ParameterizedTest
    @CsvSource({
            " , 이름을 입력하세요.",
            "hellooooojava, 이름은 " + NAME_LENGTH_LIMIT + "이하여야 합니다.",
            "test/, 이름은 영문 숫자 특수문자\\(\\_\\)만 가능합니다.",
    })
    void createCarFail(String wrongName, String errorMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarValidator.validate(wrongName))
                .withMessageMatching(errorMessage);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " ", "   ", "\t", "\n"})
    void validateNullCheck(String empty) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarValidator.validate(empty));
    }

    @DisplayName("특수문자, 한글 입력 시 에러")
    @ParameterizedTest
    @ValueSource(strings = { "name/", "%test", "te@st", "한글"})
    void validateWrongName(String wrongName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarValidator.validate(wrongName));
    }
}