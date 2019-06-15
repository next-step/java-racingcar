package step2.racing.inputter;

import org.junit.jupiter.api.Test;
import step2.racing.exception.ScanException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class FileInputterTest {

    private FileInputter fileInputter;

    @Test
    void scanIntValue() {

        fileInputter = new FileInputter("racing");

        int value = fileInputter.inputIntValue();
        assertThat(value).isEqualTo(3);
    }

    @Test
    void scanIntValue_notExistsFile() {

        fileInputter = new FileInputter("empty");

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> fileInputter.inputIntValue());
    }
}