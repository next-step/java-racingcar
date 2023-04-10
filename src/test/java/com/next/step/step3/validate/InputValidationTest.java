package com.next.step.step3.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("자동차 대수가 0일 때 예외가 발생하는 테스트")
    void validateNumOfCars_자동차_대수가_0인_경우_테스트() {
        int numOfCars = 0;
        assertThatThrownBy(() -> inputValidation.validateNumOfCars(numOfCars))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("최소 1대의 차량이 필요합니다.");
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
