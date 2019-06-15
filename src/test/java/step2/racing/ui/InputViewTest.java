package step2.racing.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import step2.racing.exception.ScanException;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    InputView inputView;

    @Test
    void askCarCount() {

        String input = "3";
        mockInputStream(input);
        inputView = new InputView();

        assertThat(inputView.askCarCount()).isEqualTo(Integer.valueOf(input));
    }

    @Test
    void askCarCount_IllegalArgumentException() {

        String input = "abc";
        mockInputStream(input);
        inputView = new InputView();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.askCarCount())
                .withMessage("숫자를 입력해주세요");
    }

    @Test
    void askCarCount_ScanException() {

        String input = "";
        mockInputStream(input);
        inputView = new InputView();

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> inputView.askCarCount())
                .withMessage("입력 도중 에러가 발생했습니다");
    }

    @Test
    void askAttemptingTimes() {

        String input = "3";
        mockInputStream(input);
        inputView = new InputView();

        assertThat(inputView.askAttemptingTimes()).isEqualTo(Integer.valueOf(input));
    }

    @Test
    void askAttemptingTimes_IllegalArgumentException() {

        String input = "abc";
        mockInputStream(input);
        inputView = new InputView();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.askAttemptingTimes())
                .withMessage("숫자를 입력해주세요");
    }

    @Test
    void askAttemptingTimes_ScanException() {

        String input = "";
        mockInputStream(input);
        inputView = new InputView();

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> inputView.askAttemptingTimes())
                .withMessage("입력 도중 에러가 발생했습니다");
    }

    @AfterEach
    void tearDown() {

        System.setIn(System.in);

    }

    private void mockInputStream(String input) {

        byte[] inputBytes = input.getBytes();
        System.setIn(new ByteArrayInputStream(inputBytes));
    }
}
