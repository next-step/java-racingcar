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

    @DisplayName("입력값 유효성 에러")
    @ParameterizedTest
    @CsvSource({
            "1,     test1/test2/test3",
            "1,     test1.",
            "-1,     test1,test2",
    })
    void validateCarNames(int round, String wrongNameText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameRequest.valueOf(round, wrongNameText));
    }

    @DisplayName("자동차 문자열 입력값이 null 일 때 에러")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " ", "   ", "\t", "\n" })
    void validateWrongRoundThenFail(String names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameRequest.valueOf(1, names));
    }
}