package racingcar.validate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validate.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @BeforeAll
    static void initAll() {
        System.out.println("start Validator test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("end Validator test");
    }

    @DisplayName("checkEmptyInputTest: 이름이 빈 문자열인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void checkEmptyInputTest(String input) {
        assertThatThrownBy(() -> Validator.checkEmptyInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkLastValueCommaTest: 입력 문자열 마지막이 ,인 지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"뽀로로,루피,", "뽀로,,로로,", "로로,뽀로로,", "루피뽀롱,"})
    void checkLastValueCommaTest(String input) {
        assertThatThrownBy(() -> Validator.checkLastValueComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkGreaterThan5Test: 차 이름이 5글자 이상인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"뽀로로D바보", "루뽀루루뽀루", "로몽키디뿌루루피", "뽀롱뽀롱루피뽀롱"})
    void checkGreaterThan5Test(String input) {
        assertThatThrownBy(() -> Validator.checkGreaterThan5(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkDuplicateNameTest: 중복 이름이 있는지확인")
    @ParameterizedTest
    @ValueSource(strings = {"루피,루피,뽀로로,배찌", "흰수염뽀로롱이,루피,흰수염뽀로롱이,", ",,그리리기리기,언더더씨,배찌,배찌,배"})
    void checkDuplicateNameTest(String input) {
        assertThatThrownBy(() -> Validator.checkDuplicateName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkNumberTest: 게임 스테이지 입력이 숫자인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"44d", "4 4", "ddd987", "ddd"})
    void checkNumberTest(String input) {
        assertThatThrownBy(() -> Validator.checkNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}