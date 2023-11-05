package racinggame.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.MisMatchNumberException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"test, !"})
    @DisplayName("실패 - 레이싱 횟수 입력 시 숫자 형식이 아닌 문자를 입력할 경우 예외가 발생한다.")
    void fail_input_mismatch_number_racing_count(String text) {
        // given
        InputView inputView = new InputView(scanner(text));

        // when & then
        Assertions.assertThatThrownBy(inputView::racingCount)
                .isInstanceOf(MisMatchNumberException.class)
                .hasMessage("숫자 형식의 값만 입력할 수 있습니다.");
    }

    private Scanner scanner(String text) {
        System.setIn(inputStream(text));
        return new Scanner(System.in);
    }

    private InputStream inputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}
