package step2.racing.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import step2.racing.exception.ScanException;
import step2.racing.scanner.SystemConsoleInputScanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static step2.racing.testutil.InputStreamMockUtil.mockInputStream;

class InputViewTest {

    InputView inputView;

    @Test
    void askCarCount() {

        String input = "3";
        mockInput(input);

        assertThat(inputView.askCarCount()).isEqualTo(Integer.valueOf(input));
    }

    @Test
    void askCarCount_notNumber() {

        mockInput("abc");

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> inputView.askCarCount())
                .withMessage("숫자를 입력해주세요");
    }

    @Test
    void askCarCount_exception() {

        mockInput("");

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> inputView.askCarCount())
                .withMessage("입력 도중 에러가 발생했습니다");
    }

    @Test
    void askAttemptingTimes() {

        String input = "3";
        mockInput(input);

        assertThat(inputView.askAttemptingTimes()).isEqualTo(Integer.valueOf(input));
    }

    @Test
    void askAttemptingTimes_notNumber() {

        mockInput("abc");

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> inputView.askAttemptingTimes())
                .withMessage("숫자를 입력해주세요");
    }

    @Test
    void askAttemptingTimes_exception() {

        mockInput("");

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> inputView.askAttemptingTimes())
                .withMessage("입력 도중 에러가 발생했습니다");
    }

    @AfterEach
    void tearDown() {

        System.setIn(System.in);
    }

    private void mockInput(String input) {

        mockInputStream(input);
        inputView = new InputView(new SystemConsoleInputScanner());
    }

}
