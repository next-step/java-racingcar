package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @DisplayName("올바른 입력값에 따른 전체 계산 결과 확인")
    @ParameterizedTest
    @CsvSource({"1 + 2 * 6, 18", "3 - 1 * 14 / 7, 4", "1 + 1 + 1 + 1, 4"})
    public void calculate(String input, int expected){
        StringCalculator calculator = new StringCalculator(new ByteArrayInputStream(input.getBytes()));
        int result = 0;

        try {
            Class<?> cls = calculator.getClass();
            Method method = cls.getDeclaredMethod("calculate", String.class);
            method.setAccessible(true);
            Accumulator accumulator = (Accumulator) method.invoke(calculator, input);
            result= accumulator.getValue();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {}

        assertThat(result).isEqualTo(expected);
    }
}
