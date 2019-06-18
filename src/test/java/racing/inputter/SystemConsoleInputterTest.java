package racing.inputter;

import learn.StubSystemInputLearnTest;
import org.junit.jupiter.api.*;
import racing.exception.ScanException;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SystemConsoleInputterTest {

    private SystemConsoleInputter systemConsoleInputter;

    @Test
    @DisplayName("시스템 콘솔을 통해 숫자를 입력")
    void scanIntValue() {

        String input = "3";
        stubInputStream(input);

        int value = systemConsoleInputter.getIntValue();
        assertThat(value).isEqualTo(Integer.valueOf(input));
    }

    @Test
    @DisplayName("시스템 콘솔을 통해 숫자를 입력받을 때 숫자가 아니라면 ScanException 발생")
    void scanIntValue_notNumber() {

        String input = "abc";
        stubInputStream(input);

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> systemConsoleInputter.getIntValue());
    }

    @Test
    @DisplayName("시스템 콘솔을 통해 숫자를 입력받을 때 아무 값도 없다면 ScanException 발생")
    void scanIntValue_thrown_exception() {

        String input = "";
        stubInputStream(input);

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> systemConsoleInputter.getIntValue())
                .withCause(new NoSuchElementException());
    }

    @AfterEach
    void tearDown() {

        System.setIn(System.in);
    }

    private void stubInputStream(String input) {

        StubSystemInputLearnTest.stubInputStream(input);
        systemConsoleInputter = new SystemConsoleInputter();
    }

}