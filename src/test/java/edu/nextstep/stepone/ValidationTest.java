package edu.nextstep.stepone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-14 15:39
 */
public class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3", "+", "-", "*", "/"})
    void 공백제거_리스트반환(String compareStr) {
        Validation validation = new Validation();
        assertThat(validation.splitSpace("1 + 2 - 1 * 2 / 3").contains(compareStr)).isTrue();
    }

    @Test
    void 연산자_데이터유무체크() {
        Validation validation = new Validation();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            validation.isBlank(" ");
        });
    }

    @Test
    void 연산자_타입체크() {
        OperatorType type = OperatorType.typeCheck("+");
        assertThat(type.getType()).isEqualTo("+");
    }

    @Test
    void 연잔자_예외상황() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            OperatorType type = OperatorType.typeCheck("&");
        });
    }

    @Test
    void 숫자_포맷정상() {
        Validation validation = new Validation();
        assertThat(validation.convertInt("10")).isEqualTo(10);
    }

    @Test
    void 숫자_포맷예외상황() {
        Validation validation = new Validation();
        assertThatIllegalArgumentException().isThrownBy(() -> {
           validation.convertInt("+");
        });
    }
}
