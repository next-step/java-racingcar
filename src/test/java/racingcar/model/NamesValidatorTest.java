package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.model.NamesValidator.REGEX_CAR_NAMES_PATTERN;

public class NamesValidatorTest {

    @DisplayName("구분자 정규식 테스트")
    @Test
    void regexCarNameTest() {
        String names = "test1,test2,test3";
        String regex = REGEX_CAR_NAMES_PATTERN;
        Pattern compile = Pattern.compile(regex);
        assertThat(compile.matcher(names).matches()).isTrue();
    }

    @Test
    void createNames() {
        String nameText = "test1,test2,test3";
        NamesValidator.validate(nameText);
    }

    @DisplayName("문자열 유효성 통합 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "test1,test2",
            "테스트,test2",
    })
    void splitWrongNamesThenSuccess(String names) {
        NamesValidator.validate(names);
    }

    @DisplayName("잘못된 문자열 입력으로 실패")
    @ParameterizedTest
    @ValueSource(strings = {
            "juyoung|jinho|chloe",
            "juyoung/jinho/chloe",
            "juyoung,",
            "juyoung,tes.t",
    })
    void splitWrongNamesThenFail(String wrongNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NamesValidator.validate(wrongNames));
    }
}
