package racing.inputter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.ScanException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class FileInputterTest {

    private FileInputter fileInputter;

    @Test
    @DisplayName("파일을 통해 숫자를 입력")
    void scanIntValue() {

        fileInputter = new FileInputter("test-racing");

        int value = fileInputter.getIntValue();
        assertThat(value).isEqualTo(3);
    }

    @Test
    @DisplayName("파일이 없을 경우 ScanException 발생")
    void scanIntValue_notExistsFile() {

        fileInputter = new FileInputter("empty");

        assertThatExceptionOfType(ScanException.class)
                .isThrownBy(() -> fileInputter.getIntValue());
    }
}