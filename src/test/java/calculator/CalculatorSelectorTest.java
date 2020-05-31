package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorSelectorTest {

    private static Stream<Arguments> selectCalculator() {
        return Stream.of(
                Arguments.of("+", Calculator.ADD),
                Arguments.of("-", Calculator.SUBTRACT),
                Arguments.of("*", Calculator.MULTIPLY),
                Arguments.of("/", Calculator.DIVIDE)
        );
    }

    @ParameterizedTest
    @DisplayName("사칙연산의 구분자로 입력된 값에 매핑되는 Enum 클래스의 상수를 반환한다")
    @MethodSource("selectCalculator")
    void getCalculator(String operator, Calculator expected) {
        assertThat(CalculatorSelector.getCalculator(operator)).isEqualTo(expected);
    }
}