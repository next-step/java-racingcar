package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @DisplayName("잘못된 입력 값에 대한 정합성 검사 확인")
    @ParameterizedTest
    @ValueSource(strings = {"", "+ 2 * 3 - 5", " 1 + 2 * 3 - 6", "1+3", "5 @ 3", "1 + 2 *"})
    public void checkValidate(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(input));
    }

    @DisplayName("짝수인 경우 숫자 체크, 홀수인 경우 연산자 체크 하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void checkValidateWithIndex(int idx){
        final Method method = getDeclaredMethod("validate", int.class, String.class);
        String message = (idx % 2 == 0) ? "# is not number" : "# is not valid operator. ( +, -, *, / )";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            try {
                method.invoke(validator, idx, "#");
            } catch ( InvocationTargetException e ) {
                throw e.getCause();
            }
        }).withMessage(message);
    }

    @DisplayName("숫자가 아닌 경우 IllegalArgumentException 발생")
    @Test
    public void checkNumber() {
        final Method method = getDeclaredMethod("checkNumber", String.class);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            try {
                method.invoke(validator, "a");
            } catch ( InvocationTargetException e ) {
                throw e.getCause();
            }
        }).withMessage("a is not number");
    }

    @DisplayName("사칙연산자가 아닌 경우 IllegalArgumentException 발생")
    @Test
    public void checkOperator() {
        final Method method = getDeclaredMethod("checkOperator", String.class);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            try {
                method.invoke(validator, "#");
            } catch ( InvocationTargetException e ) {
                throw e.getCause();
            }
        }).withMessage("# is not valid operator. ( +, -, *, / )");
    }

    private Method getDeclaredMethod(String name, Class<?> ... classes) {
        Class<?> cls = validator.getClass();
        Method method = null;
        try {
            method = cls.getDeclaredMethod(name, classes);
            method.setAccessible(true);
        } catch ( NoSuchMethodException ignored ) {}
        return method;
    }
}
