package study.carrace.step3.presentation.util;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;
import static study.carrace.step3.presentation.util.UserInputPromptUtil.*;

class UserInputPromptUtilTest {
    @Test
    void 자동차_대수_입력() {
        // given
        String input = "1";

        // when
        systemSetIn(input);
        int carQuantity = askQuantityOfCars();

        // then
        assertThat(carQuantity).isEqualTo(1);
    }

    @Test
    void 유효하지_않은_자동차_대수_입력() {
        // given
        String input = "-1";

        // when
        systemSetIn(input);

        // then
        assertThatThrownBy(() -> askQuantityOfCars())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 대수는 한 대 이상이여야 합니다: -1");
    }

    private void systemSetIn(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}