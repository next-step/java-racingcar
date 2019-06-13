package study;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void substringTest() {
        String resultValue = "(1,2)".substring(1, 4);
        Assertions.assertThat(resultValue).contains("1,2");
    }
    
    @Test
    void charAtTest() {
        String givenValue = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> givenValue.charAt(10))
            .withMessageContaining("String index out of range: 10");
    }
}
