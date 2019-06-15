package step2.racing.scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import step2.racing.exception.ScanException;
import step2.racing.testutil.InputStreamMockUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SystemConsoleInputScannerTest {

    SystemConsoleInputScanner systemConsoleInputScanner;

    @Test
    void scanIntValue() {

        String input = "3";
        mockSystemConsoleInputScanner(input);

        int value = systemConsoleInputScanner.scanIntValue();
        assertThat(value).isEqualTo(Integer.valueOf(input));
    }

    @Test
    void scanIntValue_thrown_exception() {

        String input = "abc";
        mockSystemConsoleInputScanner(input);

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> systemConsoleInputScanner.scanIntValue());
    }

    @AfterEach
    void tearDown() {

        System.setIn(System.in);
    }

    private void mockSystemConsoleInputScanner(String input) {

        InputStreamMockUtil.mockInputStream(input);
        systemConsoleInputScanner = new SystemConsoleInputScanner();
    }

}