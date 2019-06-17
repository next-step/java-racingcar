package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.model.CarsValidator.REGEX_CAR_NAMES_PATTERN;

public class CarsValidatorTest {

    @DisplayName("구분자 정규식 테스트")
    @Test
    void regexCarNameTest() {
        String regex = REGEX_CAR_NAMES_PATTERN;
        Pattern compile = Pattern.compile(regex);
        assertThat(compile.matcher("test1,test2,test3").find()).isTrue();
    }

    @DisplayName("문자열 유효성 통합 테스트")
    @Test
    void textNameSplitSuccess() {
        String nameText = "test1, test2, test3";
        CarsValidator.validate(nameText);
    }

    @DisplayName("문자열 길이가 null or 빈값 or 잘못된 구분자 에러")
    @NullAndEmptySource
    @ParameterizedTest
    @ValueSource(strings = {
            "juyoung|jinho|chloe",
            "juyoung/jinho/chloe",
    })
    void textNamesSplitFail(String wrongNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarsValidator.validate(wrongNames));
    }
}
