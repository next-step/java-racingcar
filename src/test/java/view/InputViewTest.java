package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @DisplayName("자동차 대수, 시도할 회수 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5", "7"})
    void inputTestNormalCase(String count) {
        System.setIn(new ByteArrayInputStream(count.getBytes()));
        assertThat(new InputView().inputCarCount()).isEqualTo(Integer.parseInt(count));

        System.setIn(new ByteArrayInputStream(count.getBytes()));
        assertThat(new InputView().inputAttemptCount()).isEqualTo(Integer.parseInt(count));
    }

    @DisplayName("자동차 대수, 시도할 회수 입력 테스트 - 예외 케이스: 음수, 실수, 문자, 특수문자 입력")
    @ParameterizedTest
    @ValueSource(strings = {"-3", "-10", "-3.2", "1.2", "#@", "한대"})
    void inputTestExceptionCase(String count) {
        System.setIn(new ByteArrayInputStream(count.getBytes()));
        assertThatThrownBy(() -> new InputView().inputCarCount()).isInstanceOf(IllegalStateException.class);

        System.setIn(new ByteArrayInputStream(count.getBytes()));
        assertThatThrownBy(() -> new InputView().inputAttemptCount()).isInstanceOf(IllegalStateException.class);
    }
}
