package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.model.GameRequest.REGEX_NAMES_PATTERN;

public class GameRequestTest {

    @DisplayName("자동차 이름 정규식 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "test1,test2,test3",
            "test1,한글"
    })
    void regexCarNameTest(String names) {
        Pattern compile = Pattern.compile(REGEX_NAMES_PATTERN);
        assertThat(compile.matcher(names).matches()).isTrue();
    }

    @DisplayName("자동차 이름 문자열의 유효성 검사 에러")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "test1/test2/test3",
            "test1.",
    })
    void validateCarNames(String wrongNameText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameRequest.validateCarNames(wrongNameText));
    }

    @DisplayName("실행 횟수가 음수일 시 에러")
    @Test
    void validateWrongRoundThenFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameRequest.validateMinRound(-1));
    }
}