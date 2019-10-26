package stringcalculator.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorBufferTest {

    private static Stream<Arguments> illegalOrderInputs() {
        String[] first = new String[]{"1", "1", "+"};
        String[] second = new String[]{"1", "+", "+"};
        return Stream.of(
                Arguments.of(first, "숫자의 순서가 올바르지 않습니다."),
                Arguments.of(second, "연산자의 순서가 올바르지 않습니다.")
        );
    }

    @ParameterizedTest
    @MethodSource("illegalOrderInputs")
    void validateOperateOrder_올바르지_않은_입력순서일때(String[] illegalOrderInputs, String message) {
        //given

        //when
        //then
        assertThatThrownBy(() -> new CalculatorBuffer(illegalOrderInputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    void validateOperate_계산_불가능한_입력시() {
        //given
        String[] illegalSizeInput = new String[]{"1", "-", "2", "+"};
        //when
        //then
        assertThatThrownBy(() -> new CalculatorBuffer(illegalSizeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산할 수 없는 식 입니다.");
    }
}