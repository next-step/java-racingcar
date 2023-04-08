package study.carrace.step3.presentation.util;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;
import static study.carrace.step3.presentation.util.UserInputPromptUtil.*;

class UserInputPromptUtilTest {
    @Test
    void 자동차_대수() {
        systemSetIn("1");
        assertThat(askQuantityOfCars()).isEqualTo(1);
    }

    @Test
    void 유효하지_않은_자동차_대수() {
        systemSetIn("-1");
        assertThatThrownBy(() -> askQuantityOfCars())
                .isInstanceOf(IllegalArgumentException.class)
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
        assertThatThrownBy(() -> askIterationCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 한번 이상이여야 합니다: -1");
    }

    private void systemSetIn(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}