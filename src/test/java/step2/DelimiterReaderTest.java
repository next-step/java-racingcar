package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DelimiterReaderTest {

    private DelimiterReader delimiterReader = new DelimiterReader();

    @Test
    public void checkCustomIfExist() {
        boolean result = delimiterReader.hasCustomDelimiter("//;\n1;2;3");
        assertThat(result).isTrue();
    }

    @Test
    public void wrongCustomDelimiter() {
        assertThatThrownBy(() -> delimiterReader.extractAndSplit("/\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자의 사용이 잘못 되었습니다.");
    }
}
