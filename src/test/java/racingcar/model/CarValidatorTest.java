package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.model.CarValidator.NAME_LENGTH_LIMIT;

class CarValidatorTest {


    @DisplayName("자동차 이름 유효성 검사 통합 테스트")
    @ParameterizedTest
    @CsvSource({
            " , name doesn't empty",
            "hellooooojava, 이름은 " + NAME_LENGTH_LIMIT + "이하여야 합니다.",
            "test_, 이름은 영문 또는 한글만 가능합니다.",
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

    @DisplayName("특수문자, 숫자 입력 시 에러")
    @ParameterizedTest
    @ValueSource(strings = { "_name","_name/","name1","%test","te@st"})
    void validateWrongName(String wrongName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarValidator.validate(wrongName));
    }
}