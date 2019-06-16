package step2.racing.ui;

import org.junit.jupiter.api.*;
import step2.racing.exception.ScanException;
import step2.racing.inputter.SystemConsoleInputter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static util.SystemInputStubUtil.stubInputStream;

class InputViewTest {

    private InputView inputView;

    @Test
    @DisplayName("차량대수 입력 검증")
    void askCarCount() {

        String input = "3";
        mockInput(input);

        assertThat(inputView.askCarCount()).isEqualTo(Integer.valueOf(input));
    }

    @Test
    @DisplayName("차량대수 입력 시 숫자가 아니라면 ScanException 발생")
    void askCarCount_notNumber() {

        mockInput("abc");

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> inputView.askCarCount())
                .withMessage("숫자를 입력해주세요");
    }

    @Test
    @DisplayName("차량대수 입력 시 Exception 발생한다면 ScanException 으로 변환")
    void askCarCount_exception() {

        mockInput("");

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> inputView.askCarCount())
                .withMessage("입력 도중 에러가 발생했습니다");
    }

    @Test
    @DisplayName("횟수 입력 검증")
    void askAttempts() {

        String input = "3";
        mockInput(input);

        assertThat(inputView.askAttempts()).isEqualTo(Integer.valueOf(input));
    }

    @Test
    @DisplayName("횟수 입력 시 숫자가 아니라면 ScanException 발생")
    void askAttempts_notNumber() {

        mockInput("abc");

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> inputView.askAttempts())
                .withMessage("숫자를 입력해주세요");
    }

    @Test
    @DisplayName("횟수 입력 시 Exception 발생한다면 ScanException 으로 변환")
    void askAttempts_exception() {

        mockInput("");

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> inputView.askAttempts())
                .withMessage("입력 도중 에러가 발생했습니다");
    }

    @AfterEach
    void tearDown() {

        System.setIn(System.in);
    }

    private void mockInput(String input) {

        stubInputStream(input);
        inputView = new InputView(new SystemConsoleInputter());
    }

}
