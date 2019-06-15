package step2.racing.inputter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import step2.racing.exception.ScanException;
import util.SystemInputStubUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SystemConsoleInputterTest {

    SystemConsoleInputter systemConsoleInputter;

    @Test
    void scanIntValue() {

        String input = "3";
        stubInputStream(input);

        int value = systemConsoleInputter.inputIntValue();
        assertThat(value).isEqualTo(Integer.valueOf(input));
    }

    @Test
    void scanIntValue_thrown_exception() {

        String input = "abc";
        stubInputStream(input);

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> systemConsoleInputter.inputIntValue());
    }

    @AfterEach
    void tearDown() {

        System.setIn(System.in);
    }

    private void stubInputStream(String input) {

        SystemInputStubUtil.stubInputStream(input);
        systemConsoleInputter = new SystemConsoleInputter();
    }

}