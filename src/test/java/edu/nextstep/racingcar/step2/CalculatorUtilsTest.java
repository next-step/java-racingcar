package edu.nextstep.racingcar.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 사칙 연산 계산기")
class CalculatorUtilsTest {

    static class Params {

        private final Long first;
        private final Long second;

        public Params(Long first, Long second) {
            this.first = first;
            this.second = second;
        }
    }

    static class ParamsConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {

            Long first = Long.valueOf(String.valueOf(source).split(",")[0]);
            Long second = Long.valueOf(String.valueOf(source).split(",")[1]);

            return new Params(first, second);
        }
    }

    @ParameterizedTest(name = "[{index}] 덧셈 테스트, input={0}, expected={1}")
    @CsvSource(value = {"3,2:5", "1,5:6", "100,200:300"}, delimiter = ':')
    void addition(@ConvertWith(ParamsConverter.class) Params params, Long expected) {
        CalculatorUtils calculatorUtils = new CalculatorUtils();

        Long result = calculatorUtils.addition(params.first, params.second);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}] 뺄셈 테스트, input={0}, expected={1}")
    @CsvSource(value = {"3,2:1", "1,5:-4", "200,150:50"}, delimiter = ':')
    void subtraction(@ConvertWith(ParamsConverter.class) Params params, Long expected) {
        CalculatorUtils calculatorUtils = new CalculatorUtils();

        Long result = calculatorUtils.subtraction(params.first, params.second);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}] 곱셈 테스트, input={0}, expected={1}")
    @CsvSource(value = {"3,2:6", "1,5:5", "100,150:15000"}, delimiter = ':')
    void multiplication(@ConvertWith(ParamsConverter.class) Params params, Long expected) {
        CalculatorUtils calculatorUtils = new CalculatorUtils();

        Long result = calculatorUtils.multiplication(params.first, params.second);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}] 곱셈 테스트, input={0}, expected={1}")
    @CsvSource(value = {"4,2:2", "1,5:0", "5,2:2", "0,10:0"}, delimiter = ':')
    void division(@ConvertWith(ParamsConverter.class) Params params, Long expected) {
        CalculatorUtils calculatorUtils = new CalculatorUtils();

        if (params.first == 0) {
            assertThatThrownBy(() -> calculatorUtils.division(params.first, params.second))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            Long result = calculatorUtils.division(params.first, params.second);
            assertThat(result).isEqualTo(expected);
        }
    }

    @ParameterizedTest(name = "[{index}] 입력값 검증 (null 이거나 빈 공백 문자일 경우), param={0}")
    @NullAndEmptySource
    void calculator_when_null_or_empty(String source) {
        CalculatorUtils calculatorUtils = new CalculatorUtils();

        calculatorUtils.setSource(source);

        assertThatThrownBy(calculatorUtils::calculate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "[{index}] 입력값 검증 (사칙 연산 기호가 아닌 경우), param={0}")
    @ValueSource(strings = {"1 ^ 1", "1 & 1", "$ 1", "1 %"})
    void calculator_when_wrong_value(String source) {
        CalculatorUtils calculatorUtils = new CalculatorUtils();

        calculatorUtils.setSource(source);

        assertThatThrownBy(calculatorUtils::calculate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "[{index}] 사칙 연산, source={0}, expected={1}")
    @CsvSource(value = {"1 + 1:2", "1 + 1 * 2 / 2:2", "3 * 2 + 1:7"}, delimiter = ':')
    void calculator(String source, Long expected) {
        CalculatorUtils calculatorUtils = new CalculatorUtils();

        calculatorUtils.setSource(source);

        assertThat(calculatorUtils.calculate()).isEqualTo(expected);
    }
}