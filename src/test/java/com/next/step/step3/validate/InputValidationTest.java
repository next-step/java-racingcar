package com.next.step.step3.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {

    private InputValidation inputValidation = new InputValidation();

    @ParameterizedTest(name = "입력 중 음수가 존재하면 예외가 발생하는 테스트")
    @ValueSource(ints = {-1, -2, -100})
    void validateNotNegative_입력이_음수인지_확인하는_테스트(int inputNum) {
        assertThatThrownBy(() -> inputValidation.validateNotNegative(inputNum))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력에 음수 값이 포함될 수 없습니다.");
    }

    @ParameterizedTest(name = "자동차 이름이 NULL이나 빈 문자열일 때 예외가 발생하는 테스트")
    @NullAndEmptySource
    void validateNumOfCars_자동차_이름이_NULL_또는_빈_문자열인_경우_테스트(String input) {
        assertThatThrownBy(() -> inputValidation.validateExistName(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("빈 문자열이나 NULL값은 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "자동차 이름들 중 빈 문자열이 존재할 경우")
    @MethodSource("provideLessMinLengthCarName")
    void validateCarNameLength_자동차_이름들_가운데_빈_문자열인_경우(List<String> carNames) {
        assertThatThrownBy(() -> inputValidation.validateCarNameLength(carNames))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("자동차 이름의 최소 길이는 1글자입니다.");
    }

    static Stream<Arguments> provideLessMinLengthCarName() {
        return Stream.of(
                Arguments.of(List.of("a", "", "c")),
                Arguments.of(List.of("pobi", "crong", ""))
        );
    }

    @ParameterizedTest(name = "자동차 이름들 중 5글자 이상이 존재할 경우")
    @MethodSource("provideOverMaxLengthCarName")
    void validateCarNameLength_자동차_이름들_가운데_5글자_이상의_문자열인_경우(List<String> carNames) {
        assertThatThrownBy(() -> inputValidation.validateCarNameLength(carNames))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("자동차 이름의 최대 길이는 5글자입니다.");
    }

    static Stream<Arguments> provideOverMaxLengthCarName() {
        return Stream.of(
                Arguments.of(List.of("a", "b", "cccccc")),
                Arguments.of(List.of("pobi", "crong", "martini"))
        );
    }

    @Test
    @DisplayName("경기 회수가 0일 때 예외가 발생하는 테스트")
    void validateNumOfAttempts_경기_회수가_0인_경우_테스트() {
        int numOfAttempts = 0;
        assertThatThrownBy(() -> inputValidation.validateNumOfAttempts(numOfAttempts))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("최소 1번의 경기는 진행되어야 합니다.");
    }
}
