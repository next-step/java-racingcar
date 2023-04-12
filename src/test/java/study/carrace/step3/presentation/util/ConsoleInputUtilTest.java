package study.carrace.step3.presentation.util;

import org.junit.jupiter.api.Test;
import study.carrace.step3.presentation.exception.IllegalCarNameException;
import study.carrace.step3.presentation.exception.IllegalCarQuantityException;
import study.carrace.step3.presentation.exception.IllegalIterationCountException;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;
import static study.carrace.step3.presentation.util.ConsoleInputUtil.*;

class ConsoleInputUtilTest {
    @Test
    void car_quantity() {
        systemSetIn("1");
        assertThat(askCarQuantity()).isEqualTo(1);
    }

    @Test
    void invalid_car_quantity() {
        systemSetIn("-1");
        assertThatThrownBy(ConsoleInputUtil::askCarQuantity)
                .isInstanceOf(IllegalCarQuantityException.class)
                .hasMessage("자동차 대수는 한 대 이상이여야 합니다: -1");
    }

    @Test
    void iteration_count() {
        systemSetIn("1");
        assertThat(askIterationCount()).isEqualTo(1);
    }

    @Test
    void invalid_iteration_count() {
        systemSetIn("-1");
        assertThatThrownBy(ConsoleInputUtil::askIterationCount)
                .isInstanceOf(IllegalIterationCountException.class)
                .hasMessage("시도 횟수는 한번 이상이여야 합니다: -1");
    }

    @Test
    void car_names() {
        systemSetIn("pobi,crong,honux");
        assertThat(askCarNames()).containsExactly("pobi", "crong", "honux");
    }

    @Test
    void invalid_car_names() {
        systemSetIn("pobi,crong,honux,abcdef");
        assertThatThrownBy(() -> askCarNames())
                .isInstanceOf(IllegalCarNameException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다: abcdef");
    }

    private void systemSetIn(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}