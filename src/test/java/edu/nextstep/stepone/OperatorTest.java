package edu.nextstep.stepone;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-14 14:33
 */
public class OperatorTest {

    @Test
    void 덧셈() {
        assertThat(OperatorType.typeCheck("+").calculate(10, 20)).isEqualTo(30);
    }

    @Test
    void 뺄셈() {
        assertThat(OperatorType.typeCheck("-").calculate(10, 20)).isEqualTo(-10);
    }

    @Test
    void 곱셈() {
        assertThat(OperatorType.typeCheck("*").calculate(100, 2)).isEqualTo(200);
    }

    @Test
    void 나눗셈() {
        assertThat(OperatorType.typeCheck("/").calculate(100, 2)).isEqualTo(50);
    }

    /*
    연산 종합 테스트
     */
    @Test
    void 종합테스트() {
        CalculatorApplication app = new CalculatorApplication();
        assertThat(app.start("3 + 2 - 1")).isEqualTo(4);
        assertThat(app.start("3 + 2 * 3")).isEqualTo(15);
        assertThat(app.start("3 + 2 - 5 + 10 / 2")).isEqualTo(5);
    }
}
