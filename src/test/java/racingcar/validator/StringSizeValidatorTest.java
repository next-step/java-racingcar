package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class StringSizeValidatorTest {

    private Validator<String[], String> validator = new StringSizeValidator();

    @ParameterizedTest
    @DisplayName("입력값 이름 5자 초과 테스트")
    @ValueSource(strings = {"hongasdf,honga","hong,hongag", "hon,hon#$$%g"})
    void valid(String input) {
        assertThatThrownBy(() -> {
            validator.valid(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력값 입니다");
    }

}