package step2.racing.scanner;

import org.junit.jupiter.api.Test;
import step2.racing.exception.ScanException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class FileInputScannerTest {

    private FileInputScanner fileInputScanner;

    @Test
    void scanIntValue() {

        fileInputScanner = new FileInputScanner("racing");

        int value = fileInputScanner.scanIntValue();
        assertThat(value).isEqualTo(3);
    }

    @Test
    void scanIntValue_notExistsFile() {

        fileInputScanner = new FileInputScanner("empty");

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> fileInputScanner.scanIntValue());
    }
}