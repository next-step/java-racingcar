package study.carrace.step3.presentation.util;

import org.junit.jupiter.api.Test;
import study.carrace.step3.presentation.exception.IllegalCarQuantityException;
import study.carrace.step3.presentation.exception.IllegalIterationCountException;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;
import static study.carrace.step3.presentation.util.ConsoleInputUtil.*;

class ConsoleInputUtilTest {
    @Test
    void 자동차_대수() {
        systemSetIn("1");
        assertThat(askCarQuantity()).isEqualTo(1);
    }

    @Test
    void 유효하지_않은_자동차_대수() {
        systemSetIn("-1");
        assertThatThrownBy(ConsoleInputUtil::askCarQuantity)
                .isInstanceOf(IllegalCarQuantityException.class)
                .hasMessage("자동차 대수는 한 대 이상이여야 합니다: -1");
    }

    @Test
    void 시도_횟수() {
        systemSetIn("1");
        assertThat(askIterationCount()).isEqualTo(1);
    }

    @Test
    void 유효하지_않은_시도_횟수() {
        systemSetIn("-1");
        assertThatThrownBy(ConsoleInputUtil::askIterationCount)
                .isInstanceOf(IllegalIterationCountException.class)
                .hasMessage("시도 횟수는 한번 이상이여야 합니다: -1");
    }

    private void systemSetIn(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}